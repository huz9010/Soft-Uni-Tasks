package MultidimensionalArraysExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            Pattern pattern = Pattern.compile("swap\\s+-?[0-9]+\\s+-?[0-9]+\\s+-?[0-9]+\\s+-?[0-9]+\\s*");
            Matcher matcher = pattern.matcher(input);

            int row1 = -1;
            int col1 = -1;
            int row2 = -1;
            int col2 = -1;

            if (!matcher.matches()) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else {
                String[] inputCommand = input.split("\\s+");
                row1 = Integer.parseInt(inputCommand[1]);
                col1 = Integer.parseInt(inputCommand[2]);
                row2 = Integer.parseInt(inputCommand[3]);
                col2 = Integer.parseInt(inputCommand[4]);
            }

            if (!areValidCoordinates(matrix, row1, col1, row2, col2)) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }   else {
                swapElements(matrix, row1, col1, row2, col2);
                printMatrix(matrix);
            }
            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static boolean areValidCoordinates (String[][] matrix, int row1, int col1, int row2, int col2)   {
        return row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length
                && col1 >= 0 && col1 < matrix[row1].length && col2 >= 0 && col2 < matrix[row2].length;
    }

    public static void swapElements (String[][] matrix, int row1, int col1, int row2, int col2)    {
        String ElementToSwap = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = ElementToSwap;

    }
}
