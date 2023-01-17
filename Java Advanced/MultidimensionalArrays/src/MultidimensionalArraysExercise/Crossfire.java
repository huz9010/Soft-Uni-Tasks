package MultidimensionalArraysExercise;

import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        fillTheMatrix(matrix);

        
    }

    private static void fillTheMatrix(int[][] matrix) {
        int counter = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = counter;
                counter++;
            }
        }
    }

    public static boolean isValidIndex (int r, int c, int[][] matrix)   {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
