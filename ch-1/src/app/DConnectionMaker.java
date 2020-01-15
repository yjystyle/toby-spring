package app;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DConnectionMaker
 */
public class DConnectionMaker implements ConnectionMaker {

    @Override
    public Connection makeconnection() throws ClassNotFoundException, SQLException {
        // D 사의 독자적인 방법으로 Connection을 생성하는 코드
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection("jdbc:h2:~/apps/h2db/crm;AUTO_SERVER=TRUE", "sa", "sa");
        return c;
    }

    
}