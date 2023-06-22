import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DBConnection {
    ;

    public static Connection getSqlConnection() throws SQLException {
        final Properties credentials = new Properties();
        credentials.setProperty(ConnectionSettings.USER_KEY, ConnectionSettings.USER_VALUE);
        credentials.setProperty(ConnectionSettings.PASSWORD_KEY, ConnectionSettings.PASSWORD_VALUE);

        return DriverManager.getConnection(ConnectionSettings.DB_URL, credentials);
    }
}
