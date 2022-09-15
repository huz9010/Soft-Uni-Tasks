package NestedLoopsMoreExercises;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magic = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean yes = false;

        for (int i = start; i <= end; i++) {

            for (int j = start; j <= end; j++) {

                counter++;

                if (i + j == magic) {
                    yes = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, (i + j));
                    break;
                }
            }
            if (yes) {
                break;
            }
        }
        if (!yes) {
            System.out.printf("%d combinations - neither equals %d", counter, magic);
        }
    }
}
