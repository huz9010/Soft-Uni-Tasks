import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddMinion {

    private static final String DEFAULT_EVILNESS_FACTOR = "evil";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final String[] minionInfo = scanner.nextLine().split("\\s+");
        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTown = minionInfo[3];

        final String villainName = scanner.nextLine().split("\\s+")[1];

        final Connection connection = DBConnection.getSqlConnection();

        int townId = getEntryId(List.of(minionTown),
                connection,
                Queries.GET_TOWN_ID_BY_NAME,
                Queries.INSERT_INTO_TOWNS,
                Messages.PRINT_FORMAT_ADD_TOWN);

        int villainId = getEntryId(List.of(villainName, DEFAULT_EVILNESS_FACTOR),
                connection,
                Queries.GET_VILLAIN_ID_BY_NAME,
                Queries.INSERT_INTO_VILLAINS,
                Messages.PRINT_FORMAT_ADD_VILLAIN);

        final PreparedStatement insertMinion = connection.prepareStatement(Queries.INSERT_INTO_MINIONS);
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        final PreparedStatement getMinionId = connection.prepareStatement(Queries.GET_MINION_ID_BY_NAME);
        getMinionId.setString(1, minionName);
        ResultSet minionIdResultSet = getMinionId.executeQuery();
        minionIdResultSet.next();
        int minionId = minionIdResultSet.getInt("id");

        final PreparedStatement insertMinionsVillains = connection.prepareStatement(Queries.INSERT_MINIONS_VILLAINS);
        insertMinionsVillains.setInt(1,  minionId);
        insertMinionsVillains.setInt(2,  villainId);
        insertMinionsVillains.executeUpdate();

        System.out.printf(Messages.PRINT_FORMAT_MINION_ADDED_TO_VILLAIN, minionName, villainName);
        connection.close();
    }

    private static int getEntryId(List<String> arguments, Connection connection, String getQuery, String insertQuery, String printFormat) throws SQLException {
        final PreparedStatement getId = connection.prepareStatement(getQuery);
        getId.setString(1, arguments.get(0));
        ResultSet idResultSet = getId.executeQuery();

        if (!idResultSet.next()) {
            final PreparedStatement insertEntry = connection.prepareStatement(insertQuery);
            for (int i = 1; i <= arguments.size(); i++) {
                insertEntry.setString(i, arguments.get(i - 1));
            }
            insertEntry.executeUpdate();
            System.out.printf(printFormat, arguments.get(0));

            final ResultSet afterInsert = getId.executeQuery();
            afterInsert.next();
            return afterInsert.getInt("id");
        }
        return idResultSet.getInt("id");
    }
}
