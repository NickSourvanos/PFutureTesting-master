package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/pfuturedb?" +
            "user=root&password=1234&useSSL=false&useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}