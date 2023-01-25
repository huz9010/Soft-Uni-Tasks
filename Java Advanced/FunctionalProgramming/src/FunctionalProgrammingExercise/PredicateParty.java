package FunctionalProgrammingExercise;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {

            String[] inputArr = input.split("\\s+");
            String command = inputArr[0];
            String condition = inputArr[1];
            String value = inputArr[2];
            switch (command) {
                case "Remove":
                    removeGuests(guests, condition, value);
                    break;
                case "Double":
                    doubleGuests(guests, condition, value);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown command: " + command);
            }

            input = scanner.nextLine();
        }
        if (guests.isEmpty())   {
            System.out.println("Nobody is going to the party!");
        }   else {
            System.out.println(guests.stream().sorted().collect(Collectors.joining(", ")) +  " are going to the party!");
        }
    }

    private static void doubleGuests(List<String> guests, String condition, String value) {
        int length = guests.size();
        if (condition.equals("StartsWith")) {
            for (int i = 0; i < length; i++) {
                if(guests.get(i).startsWith(value))  {
                    guests.add(guests.get(i));
                }
            }
        } else if (condition.equals("EndsWith")) {
            for (int i = 0; i < length; i++) {
                if(guests.get(i).endsWith(value))  {
                    guests.add(guests.get(i));
                }
            }
        } else if (condition.equals("Length")) {
            for (int i = 0; i < length; i++) {
                if (guests.get(i).length() == Integer.parseInt(value))  {
                    guests.add(guests.get(i));
                }
            }
        }
    }

    public static void removeGuests (List<String> guests, String condition, String value) {
        if (condition.equals("StartsWith")) {
            guests.removeIf(e -> e.startsWith(value));
        } else if (condition.equals("EndsWith")) {
            guests.removeIf(e -> e.endsWith(value));
        } else if (condition.equals("Length")) {
            guests.removeIf(e -> e.length() == Integer.parseInt(value));
        }
    }
}
