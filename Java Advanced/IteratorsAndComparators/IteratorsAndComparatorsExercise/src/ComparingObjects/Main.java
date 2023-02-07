package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("END"))    {
            String[] command = input.split("\\s+");
            people.add(new Person(command[0], Integer.parseInt(command[1]), command[2]));

            input = scanner.nextLine();
        }

        int personToCompareIndex = Integer.parseInt(scanner.nextLine());
        Person personToCompare = people.get(personToCompareIndex - 1);

        int matches = 0;

        for (Person person : people)    {
            if (person.compareTo(personToCompare) == 0) {
                matches++;
            }
        }

        if (matches < 2)    {
            System.out.println("No matches");
        }   else {
            System.out.printf("%d %d %d", matches, people.size() - matches, people.size());
        }
    }
}
