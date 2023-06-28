import entities.Project;

public class FindLatest10Projects {
    public static void main(String[] args) {

        Setup.createEntityManager().createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(Project::printProjectInfo);
    }
}
