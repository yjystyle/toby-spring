package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * SimpleConnectionMaker 라는 클래스를 만들고 UserDao4가 이용한다.
 */
public class UserDao6 {

    private ConnectionMaker connectionMaker;
    UserDao6(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
   
    /**
     * getConnection() 메소드를 출해서 중복을 제거하였다. 
     *
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException {
        
        Connection c = connectionMaker.makeConnection();
        
        // 내장 DB인 h2를 사용하면서 table이 존재하지 않기 때문에 책과 다르게 CREATE 쿼리를 실행하는 로직이 필요했다.
        PreparedStatement psC = c.prepareStatement("CREATE TABLE USERS (ID VARCHAR(20) PRIMARY KEY, NAME VARCHAR(20) NOT NULL, PASSWORD VARCHAR(10) NOT NULL)");
        psC.executeUpdate();
        psC.close();

        PreparedStatement psI = c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
        psI.setString(1, user.getId());
        psI.setString(2, user.getName());
        psI.setString(3, user.getPassword());
        
        psI.executeUpdate();
        psI.close();
        c.close();
    }

    

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;

    }
}