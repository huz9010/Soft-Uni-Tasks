import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {

        final String country = new Scanner(System.in).nextLine();

        final Connection connection = DBConnection.getSqlConnection();


        final PreparedStatement changeCase = connection.prepareStatement(Queries.CHANGE_TOWN_NAME_CASE);
        changeCase.setString(1, country);
        final int townCount = changeCase.executeUpdate();

        if (townCount == 0) {
            System.out.println(Messages.PRINT_NO_TOWNS_AFFECTED);
            connection.close();
            return;
        }

        System.out.printf(Messages.PRINT_COUNT_TOWNS_AFFECTED, townCount);

        final PreparedStatement selectTowns = connection.prepareStatement(Queries.SELECT_TOWN_BY_COUNTRY);
        selectTowns.setString(1, country);
        final ResultSet townsResultSet = selectTowns.executeQuery();

        List<String> towns = new ArrayList<>();
        while (townsResultSet.next()) {
            towns.add(townsResultSet.getString("name"));
        }

        System.out.println(towns);
        connection.close();
    }
}
