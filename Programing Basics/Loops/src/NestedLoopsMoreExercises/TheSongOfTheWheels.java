package NestedLoopsMoreExercises;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int control = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        boolean isFound = false;

        for (int i = 1; i <= 9; i++) {

            for (int j = 1; j <= 9; j++) {

                for (int k = 1; k <= 9; k++) {

                    for (int l = 1; l <= 9; l++) {

                        if (i < j && k > l && (i * j + k * l == control)) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                            counter++;

                            if (counter == 4) {
                                isFound = true;
                                a = i;
                                b = j;
                                c = k;
                                d = l;
                            }
                        }
                    }
                }
            }
        }
        if (isFound)   {
            System.out.printf("%nPassword: %d%d%d%d", a, b, c, d);
        }   else
            System.out.printf("%nNo!");
    }
}
