package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

    /**
     * 더 이상 상속을 이용한 확장 방식을 사용하지 않으니 추상 클래스로 만들 필요는 없다.
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection("jdbc:h2:~/apps/h2db/crm;AUTO_SERVER=TRUE", "sa", "sa");
        return c;
    }
}
