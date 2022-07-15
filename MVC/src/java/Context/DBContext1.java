package Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext1 {

    Connection cnn;

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
 /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public DBContext1() {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, userID, password);
        } catch (Exception e) {
            System.out.println("Error :" +e.getMessage());
        }
    }

    /*Insert your other code right after this comment*/
 /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "DESKTOP-MCMOCN4\\SQLEXPRESS";
    private final String dbName = "ProductOrder";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "1001";
}
