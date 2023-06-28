import entities.Address;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {

        Setup.createEntityManager().createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(Address::printTextAndEmployeeCount);
    }
}
