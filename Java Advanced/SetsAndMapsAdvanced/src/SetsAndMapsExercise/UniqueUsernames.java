package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userCount = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> users = new LinkedHashSet<>();

        while (userCount-- > 0) {
            users.add(scanner.nextLine());
        }

        for (String user : users) {
            System.out.println(user);
        }
    }
}
