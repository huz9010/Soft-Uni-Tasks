package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        LinkedHashMap<String, String> contacts = new LinkedHashMap<>();

        while (!name.equals("stop"))    {
            String email = scanner.nextLine().toLowerCase();

            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")){
                contacts.put(name, email);
            }
            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> contact : contacts.entrySet()) {
            System.out.printf("%s -> %s%n", contact.getKey(), contact.getValue());
        }
    }
}
