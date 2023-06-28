public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        Setup.createEntityManager()
                .createQuery("SELECT department.name, max(salary)" +
                        " FROM Employee " +
                        " GROUP BY department.name" +
                        " HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(o -> System.out.println(o[0] + " " + o[1]));

        System.out.println(System.lineSeparator());
    }
}
