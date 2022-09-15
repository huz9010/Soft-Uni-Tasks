package NestedLoopsMoreExercises;

import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstPair = Integer.parseInt(scanner.nextLine());
        int secondPair = Integer.parseInt(scanner.nextLine());
        int firstDiff = Integer.parseInt(scanner.nextLine());
        int secondDiff = Integer.parseInt(scanner.nextLine());

        for (int i = firstPair; i < (firstPair + firstDiff + 1); i++) {

            int counter1 = 0;

            for (int k = 1; k <= i; k++) {
                if (i % k == 0) {
                    counter1++;
                }
            }
            if (counter1 == 2) {

                for (int j = secondPair; j < (secondPair + secondDiff + 1); j++) {

                    int counter2 = 0;

                    for (int l = 1; l <= j; l++) {
                        if (j % l == 0) {
                            counter2++;
                        }
                    }

                    if (counter2 == 2) {
                        System.out.printf("%d%d%n", i, j);
                    }
                }
            }
        }
    }
}
