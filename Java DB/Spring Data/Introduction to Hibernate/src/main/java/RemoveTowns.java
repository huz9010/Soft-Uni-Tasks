import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String townName = br.readLine();

        EntityManager em = Setup.createEntityManager();

        em.getTransaction().begin();

        Town townDelete = em.createQuery("FROM Town "
                        + "WHERE name = :town", Town.class)
                .setParameter("town", townName)
                .getSingleResult();

        List<Address> addressesToDelete = em
                .createQuery("FROM Address WHERE town.id= :id", Address.class)
                .setParameter("id", townDelete.getId())
                .getResultList();

        addressesToDelete
                .forEach(t -> t.getEmployees()
                        .forEach(e -> e.setAddress(null)));

        addressesToDelete.forEach(em::remove);
        em.remove(townDelete);

        int countDeletedAddresses = addressesToDelete.size();

        System.out.printf("%d address%s in %s deleted",
                countDeletedAddresses,
                countDeletedAddresses == 1 ? "" : "es",
                townName);

        em.getTransaction().commit();
    }
}
