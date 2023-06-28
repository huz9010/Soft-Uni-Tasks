import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {

        EntityManager em = Setup.createEntityManager();

        em.getTransaction().begin();

        List<Town> allTowns = em.createQuery("FROM Town", Town.class).getResultList();

        for(Town town : allTowns) {
            if (town.getName().length() > 5)    {
                em.detach(town);
                continue;
            }

            town.setName(town.getName().toUpperCase());
            em.persist(town);
        }

        em.getTransaction().commit();
        em.close();
    }
}
