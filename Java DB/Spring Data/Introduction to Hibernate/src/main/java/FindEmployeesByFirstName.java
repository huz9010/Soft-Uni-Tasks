import entities.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindEmployeesByFirstName {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern = br.readLine();

        Setup.createEntityManager().createQuery("FROM Employee WHERE firstName LIKE CONCAT(:pattern, '%')", Employee.class)
                .setParameter("pattern", pattern)
                .getResultList()
                .forEach(Employee::printEmployeeNameJobAndSalary);
    }
}
