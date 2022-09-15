package NestedLoopsMoreExercises;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1Max = Integer.parseInt(scanner.nextLine());
        int num2Max = Integer.parseInt(scanner.nextLine());
        int num3Max = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num1Max ; i++) {

            int num1 = 0;
            int num2 = 0;
            int num3 = 0;

            if (i % 2 == 0) {
                num1 = i;

            }   else {
                continue;
            }

            for (int j = 1; j <= num2Max; j++) {
                int counter = 0;
                for (int l = 1; l <= j; l++) {

                    if (j % l == 0) {
                        counter++;
                    }
                }
                if (counter == 2) {
                    num2 = j;

                } else {
                    continue;
                }

                for (int k = 1; k <= num3Max ; k++) {
                    if (k % 2 == 0) {
                        num3 = k;
                        System.out.printf("%d %d% d%n", num1, num2 ,num3);
                    }
                }

            }
        }
    }
}
