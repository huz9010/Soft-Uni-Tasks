package NestedLoopsMoreExercises;

import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lv1 = Integer.parseInt(scanner.nextLine());
        int lv2 = Integer.parseInt(scanner.nextLine());
        int lv5 = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= lv1; i++) {

            for (int j = 0; j <= lv2; j++) {

                for (int k = 0; k <= lv5; k++) {

                    if (i + j * 2 + k * 5 == sum)   {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, sum);
                    }

                }
            }
        }
    }
}
