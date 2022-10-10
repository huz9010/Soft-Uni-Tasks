package AssociativeArraysExercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> companiesMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] companyInput = input.split(" -> ");
            String companyName = companyInput[0];
            String employeeId = companyInput[1];

            if (companiesMap.containsKey(companyName))  {
                if (!companiesMap.get(companyName).contains(employeeId)) {
                    companiesMap.get(companyName).add(employeeId);
                }
            }   else {
                List<String> employeeList = new ArrayList<>();
                employeeList.add(employeeId);
                companiesMap.put(companyName, employeeList);
            }
            input = scanner . nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companiesMap.entrySet()) {
            System.out.println(entry.getKey());
            for (String element : entry.getValue()) {
                System.out.println("-- " + element);
            }
        }
    }
}
