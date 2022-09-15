package NestedLoopsMoreExercises;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char lastSector = scanner.nextLine().charAt(0);
        int rowsSector1 = Integer.parseInt(scanner.nextLine());
        int oddRowSeats = Integer.parseInt(scanner.nextLine());
        int j = 1;
        int count = 0;

        for (int i = 'A'; i <= lastSector ; i++) {


            for (j = 1; j <= rowsSector1; j++) {
                if (j % 2 == 0) {
                    oddRowSeats = oddRowSeats + 2;
                }

                for (int k = 'a'; k < ('a' + oddRowSeats); k++) {

                    System.out.printf("%c%d%c%n", i, j, k);
                    count++;
                }
                if (j % 2 == 0) {
                    oddRowSeats = oddRowSeats - 2;
                }
            }
            rowsSector1++;
        }
        System.out.println(count);
    }
}
