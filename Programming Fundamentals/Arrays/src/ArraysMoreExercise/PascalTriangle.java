package ArraysMoreExercise;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        long[] array = new long[60];

        for (int i = 0; i < lines; i++) {
            array[i] = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(array[i] + " ");
                array[i] = array[i] * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
