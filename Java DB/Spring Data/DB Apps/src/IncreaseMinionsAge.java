import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {

        final int[] minionIds = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        final Connection connection = DBConnection.getSqlConnection();

        for (int minionId : minionIds) {
            final PreparedStatement updateMinions = connection.prepareStatement(Queries.UPDATE_MINIONS_NAME_AGE_BY_ID);
            updateMinions.setInt(1, minionId);
            updateMinions.executeUpdate();
        }

        final PreparedStatement getAllMinions = connection.prepareStatement(Queries.GET_ALL_MINIONS_NAME_AGE);
        final ResultSet allMinionsResultSet = getAllMinions.executeQuery();

        while (allMinionsResultSet.next())  {
            final String name = allMinionsResultSet.getString("name");
            final int age = allMinionsResultSet.getInt("age");

            System.out.printf(Messages.PRINT_FORMAT_MINIONS, name, age);
        }
        connection.close();
    }
}
