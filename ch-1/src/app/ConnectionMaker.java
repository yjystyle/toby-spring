package app;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ConnetionMaker
 */
public interface ConnectionMaker {
    public Connection makeconnection() throws ClassNotFoundException, SQLException;
    
}