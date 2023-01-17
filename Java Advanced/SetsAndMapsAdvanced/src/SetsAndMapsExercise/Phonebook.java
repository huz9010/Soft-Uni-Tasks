package SetsAndMapsExercise;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> contacts = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            contacts.put(name, number);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop"))   {
            if (!contacts.containsKey(input))   {
                System.out.printf("Contact %s does not exist.%n", input);
            }   else {
                System.out.printf("%s -> %s%n", input, contacts.get(input));
            }
            input = scanner.nextLine();
        }
    }
}
