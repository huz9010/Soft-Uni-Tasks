import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GetVillainsNames {

    private static final String PRINT_FORMAT = "%s %d";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_MINIONS_COUNT = "minions_count";

    public static void main(String[] args) throws SQLException {

        final Connection connection = DBConnection.getSqlConnection();

        final PreparedStatement statement = connection.prepareStatement(Queries.GET_VILLAINS_NAMES_AND_MINION_COUNT);
        statement.setInt(1, 15);

        final ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            print(resultSet);
        }
        connection.close();
    }

    private static void print(ResultSet resultSet) throws SQLException {
        final String name = resultSet.getString(COLUMN_LABEL_NAME);
        final int minions_count = resultSet.getInt(COLUMN_LABEL_MINIONS_COUNT);

        System.out.printf(PRINT_FORMAT, name, minions_count);
    }
}
