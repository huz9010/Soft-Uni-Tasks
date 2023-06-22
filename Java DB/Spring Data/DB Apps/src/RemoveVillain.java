import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {
    public static void main(String[] args) throws SQLException {

        final int villainId = new Scanner(System.in).nextInt();

        final Connection connection = DBConnection.getSqlConnection();

        final PreparedStatement getVillainName = connection.prepareStatement(Queries.GET_VILLAIN_NAME_BY_ID);
        getVillainName.setInt(1, villainId);
        final ResultSet villainNameResultSet = getVillainName.executeQuery();

        if (!villainNameResultSet.next())   {
            System.out.println(Messages.NO_SUCH_VILLAIN);
            connection.close();
            return;
        }

        final String villainName = villainNameResultSet.getString(1);

        final PreparedStatement getMinionCount = connection.prepareStatement(Queries.GET_MINION_COUNT_BY_VILLAIN_ID);
        getMinionCount.setInt(1, villainId);
        final ResultSet minionsCountResultSet = getMinionCount.executeQuery();
        minionsCountResultSet.next();
        final int minionsCount = minionsCountResultSet.getInt(1);

        final PreparedStatement freeMinions = connection.prepareStatement(Queries.REMOVE_MINIONS_VILLAINS_BY_VILLAIN_ID);
        freeMinions.setInt(1, villainId);
        freeMinions.executeUpdate();

        final PreparedStatement removeVillain = connection.prepareStatement(Queries.REMOVE_VILLAIN_BY_ID);
        removeVillain.setInt(1, villainId);
        removeVillain.executeUpdate();

        System.out.printf(Messages.VILLAIN_DELETED, villainName);
        System.out.printf(Messages.MINIONS_FREE, minionsCount);
        connection.close();
    }
}
