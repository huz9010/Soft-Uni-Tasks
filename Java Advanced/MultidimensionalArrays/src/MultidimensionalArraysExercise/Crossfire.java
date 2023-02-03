package MultidimensionalArraysExercise;

import java.util.*;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        fillTheMatrix(matrix);

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            String[] data = input.split("\\s+");
            int r = Integer.parseInt(data[0]);
            int c = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            matrix = destroyCells(matrix, r, c, radius);

            input = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != 0) {
                    System.out.print(matrix[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] destroyCells(int[][] matrix, int r, int c, int radius) {

        for (int row = r - radius; row <= r + radius; row++) {
            if (isValidIndex(row, c, matrix)) {
                matrix[row][c] = 0;
            }
        }
        for (int col = c - radius; col <= c + radius; col++) {
            if (isValidIndex(r, col, matrix)) {
                matrix[r][col] = 0;
            }
        }

        ArrayDeque<int[]> remainingMatrix = new ArrayDeque<>();
        for (int[] ints : matrix) {
            int[] temp = Arrays.stream(ints).filter(e -> e != 0).toArray();
            if (temp.length > 0) {
                remainingMatrix.offer(temp);
            }
        }

        int size = remainingMatrix.size();
        int[][] newMatrix = new int[remainingMatrix.size()][];

            for (int row = 0; row < size; row++) {
                newMatrix[row] = remainingMatrix.poll();
            }
        return newMatrix;
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

    public static boolean isValidIndex(int r, int c, int[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
