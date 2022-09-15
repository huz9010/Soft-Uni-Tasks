package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = Integer.parseInt(scanner.nextLine());
        List<String> guestsList = new ArrayList<>();

        for (int i = 1; i <= commandCount; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 3)  {
                    if (guestsList.contains(input[0])) {
                        System.out.println(input[0] + " is already in the list!");
                    }   else {
                        guestsList.add(input[0]);
                    }
            } else if (input.length == 4) {
                if (!guestsList.contains(input[0])) {
                    System.out.println(input[0] + " is not in the list!");
                }   else {
                    guestsList.remove(input[0]);
                }
            }
        }
        for (String element : guestsList)   {
            System.out.println(element);
        }
    }
}
