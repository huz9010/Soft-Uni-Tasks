package MultidimensionalArraysExercise;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char firstLastChar = (char) ('a' + r);
                char middleChar = (char) (firstLastChar + c);
                String currentElement = String.valueOf(firstLastChar) +
                        middleChar +
                        firstLastChar;

                matrix[r][c] = currentElement;
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
