import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) throws IOException {

        EntityManager em = Setup.createEntityManager();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lastName = br.readLine();
        br.close();

        em.getTransaction().begin();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");

        em.persist(newAddress);

        em.createQuery("FROM Employee WHERE lastName =: lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList()
                .forEach(e -> e.setAddress(newAddress));

        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
