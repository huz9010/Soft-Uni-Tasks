package NestedLoopsMoreExercises;

import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxCombos = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        char aA = 35;
        char bB = 64;

        for (int i = 1; i <= a ; i++) {

            if (counter >= maxCombos) {
                break;
            }

            for (int j = 1; j <= b ; j++) {

                if (aA > 55) {
                    aA = 35;
                }
                    if (bB > 96) {
                        bB = 64;
                    }
                        System.out.printf("%c%c%d%d%c%c|", (char) aA, (char) bB, i, j, (char) bB, (char) aA);
                    counter++;
                aA++;
                bB++;

                if (counter >= maxCombos) {
                    break;
                }
                    }
        }
    }
}
