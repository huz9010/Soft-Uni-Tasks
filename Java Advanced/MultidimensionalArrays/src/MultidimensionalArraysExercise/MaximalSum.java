package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] maxMatrix = maxSumMatrix(matrix);

        printMaxMatrix(matrix, maxMatrix);
    }

    private static void printMaxMatrix(int[][] matrix, int[] maxMatrix) {
        System.out.println("Sum = " + maxMatrix[0]);

        for (int r = maxMatrix[1]; r < maxMatrix[1] + 3; r++) {
            for (int c = maxMatrix[2]; c < maxMatrix[2] + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static int[] maxSumMatrix (int [][] matrix)  {
        int[] maxSumMatrix = new int[3];

        int maxSum = Integer.MIN_VALUE;
        int maxElementRow = Integer.MIN_VALUE;
        int maxElementCol = Integer.MIN_VALUE;
        for (int r = 0; r <= matrix.length - 3; r++) {
            for (int c = 0; c <= matrix[r].length - 3; c++) {

                int currentSum = 0;
                for (int row = r; row < r + 3; row++) {
                    for (int col = c; col < c + 3; col++) {
                        currentSum += matrix[row][col];
                    }
                }
                if (currentSum > maxSum)    {
                    maxSum = currentSum;
                    maxElementRow = r;
                    maxElementCol = c;
                }
            }
        }

        maxSumMatrix[0] = maxSum;
        maxSumMatrix[1] = maxElementRow;
        maxSumMatrix[2] = maxElementCol;
        return maxSumMatrix;
    }
}
