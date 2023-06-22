import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        int id = new Scanner(System.in).nextInt();

        final Connection connection = DBConnection.getSqlConnection();

        final CallableStatement increaseAge = connection.prepareCall(Queries.CALL_INCREASE_AGE_PROCEDURE);
        increaseAge.setInt(1, id);
        increaseAge.execute();

        final PreparedStatement getMinionNameAge = connection.prepareStatement(Queries.GET_MINION_NAME_AGE_BY_ID);
        getMinionNameAge.setInt(1, id);
        final ResultSet minion = getMinionNameAge.executeQuery();
        minion.next();

        System.out.printf(Messages.PRINT_FORMAT_MINIONS,
                minion.getString("name"),
                minion.getInt("age"));

        connection.close();
    }
}
