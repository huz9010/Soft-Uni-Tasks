import entities.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fullName = br.readLine();

        String isEmployeePresent = Setup.createEntityManager().createQuery("FROM Employee WHERE CONCAT_WS(' ', firstName, lastName) =: fullName", Employee.class)
                .setParameter("fullName", fullName).getResultList().isEmpty() ? "No" : "Yes";

        System.out.println(isEmployeePresent);
        br.close();
    }
}
