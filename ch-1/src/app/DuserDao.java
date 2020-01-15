package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * NuserDao
 */
public class DuserDao extends UserDao3 {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection("jdbc:h2:~/apps/h2db/crm;AUTO_SERVER=TRUE", "sa", "sa");
        return c;
    }
 
    
}