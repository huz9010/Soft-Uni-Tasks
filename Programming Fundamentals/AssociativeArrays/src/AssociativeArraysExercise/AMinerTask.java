package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        while (!resource.equals("stop"))    {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resources.containsKey(resource))    {
                resources.put(resource, quantity);
            }   else {
                resources.put(resource, resources.get(resource) + quantity);
            }
            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}