import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        final Connection connection = DBConnection.getSqlConnection();

        final PreparedStatement getAllMinions = connection.prepareStatement(Queries.GET_ALL_MINIONS_NAMES);
        final ResultSet minonsNamesResultSet = getAllMinions.executeQuery();

        List<String> minions = new ArrayList<>();

        while (minonsNamesResultSet.next()) {
            minions.add(minonsNamesResultSet.getString("name"));
        }

        int start = 0;
        int end = minions.size() - 1;

        while (start < end) {
            System.out.println(minions.get(start));
            System.out.println(minions.get(end));
            start++;
            end--;
        }
        connection.close();
    }
}
