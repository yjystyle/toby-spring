package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao2 {


    /**
     * getConnection() 메소드를 통해서 중복을 제거하였다. 
     *
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException {
        
        Connection c = getConnection();
        
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

    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection("jdbc:h2:~/apps/h2db/crm;AUTO_SERVER=TRUE", "sa", "sa");
        return c;
    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
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