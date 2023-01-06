package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int firstDiagonal = 0;
        int secondDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal += matrix[i][i];
            secondDiagonal += matrix[matrix.length - 1 - i][i];
        }
        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }
}
