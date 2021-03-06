package it.source.buisiness.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kolmakov Alexey on 15.07.2015.
 */
public class H2Connector  {
    static final String JDBC_DRIVER = "org.h2.Driver";
   // This pass to the database for tests
//    static final String DB_URL = "jdbc:h2:src\\main\\resources\\db\\";


   // This pass to the deployed database
    static final String DB_URL = "jdbc:h2:..\\webapps\\auto\\WEB-INF\\classes\\db\\";
    static final String DB_NAME = "auto;IFEXISTS=TRUE;AUTO_SERVER=TRUE";

    static final String USER = "sa";
    static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
