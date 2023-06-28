import entities.Project;

import java.util.Comparator;

public class FindLatest10Projects {
    public static void main(String[] args) {

        Setup.createEntityManager().createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().sorted(Comparator.comparing(Project::getName))
                .forEach(Project::printProjectInfo);
    }
}
