package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\|");

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!"))    {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Loot":


                    break;

                case "Drop":

                    break;

                case "Steal":

                    break;
            }

            input = scanner.nextLine();
        }

    }
}
