package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/pfuturedb?" +
            "user=root&password=1234&useSSL=false&useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection getDatabaseConnection() throws ClassNotFoundException{

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL);

        }catch(Exception e){ System.out.println(e);}

        return connection;
    }
}