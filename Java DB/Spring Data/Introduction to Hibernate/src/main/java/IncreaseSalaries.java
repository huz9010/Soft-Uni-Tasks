import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class IncreaseSalaries {

    final static List<String> deps = List.of("Engineering", "Tool Design", "Marketing", "Information Services");

    public static void main(String[] args) {

        EntityManager em = Setup.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employeesList = em.createQuery("FROM Employee WHERE department.name IN (:deps)", Employee.class)
                .setParameter("deps", deps)
                .getResultList();

                employeesList.forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

                em.flush();em.getTransaction().commit();
                em.close();

        employeesList.forEach(employee -> System.out.printf("%s %s ($%s)%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary().setScale(2, RoundingMode.HALF_UP)));
    }
}
