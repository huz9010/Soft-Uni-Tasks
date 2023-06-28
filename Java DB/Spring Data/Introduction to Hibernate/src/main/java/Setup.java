import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Setup {

    static EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
    }
}
