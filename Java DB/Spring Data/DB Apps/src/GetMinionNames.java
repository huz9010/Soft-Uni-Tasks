import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {

    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";
    private static final String PRINT_FORMAT_VILLAIN = "Villain: %s%n";
    private static final String PRINT_FORMAT_MINION = "%d. %s %d%n";

    public static void main(String[] args) throws SQLException {

        final Connection connection = DBConnection.getSqlConnection();

        int villainId = new Scanner(System.in).nextInt();

        final PreparedStatement getVillainName = connection.prepareStatement(Queries.GET_VILLAIN_NAME_BY_ID);
        getVillainName.setInt(1, villainId);

        ResultSet villainResultSet = getVillainName.executeQuery();

        if (!villainResultSet.next()) {
            System.out.printf(Messages.NO_VILLAIN_WITH_GIVEN_ID, villainId);
            connection.close();
            return;
        }

        final PreparedStatement getMinions = connection.prepareStatement(Queries.GET_MINIONS_NAME_AND_AGE);
        getMinions.setInt(1, villainId);

        ResultSet minionsResultSet = getMinions.executeQuery();

        print(villainResultSet, minionsResultSet);
        connection.close();
        }

    private static void print(ResultSet villainResultSet, ResultSet minionsResultSet) throws SQLException {
        final String villainName = villainResultSet.getString(COLUMN_LABEL_NAME);
        System.out.printf(PRINT_FORMAT_VILLAIN, villainName);

        for (int i = 1; minionsResultSet.next(); i++) {
            final String minionName = minionsResultSet.getString(COLUMN_LABEL_NAME);
            final int minionAge = minionsResultSet.getInt(COLUMN_LABEL_AGE);

            System.out.printf(PRINT_FORMAT_MINION, i, minionName, minionAge);
        }
    }
}

  
