import entities.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetEmployeeWithProjects {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(br.readLine());

        Setup.createEntityManager().createQuery("FROM Employee WHERE id =: id", Employee.class)
                .setParameter("id", id)
                .getResultList()
                .forEach(Employee::printEmployeeNameAndProjects);
    }
}
