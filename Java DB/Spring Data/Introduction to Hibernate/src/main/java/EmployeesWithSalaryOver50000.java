import entities.Employee;

public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {

        Setup.createEntityManager().createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList().forEach(e -> System.out.println(e.getFirstName()));
    }
}
