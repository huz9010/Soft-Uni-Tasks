package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        for (int[] arrays : matrix) {
            for (int element : arrays) {
                sum += element;
            }
        }

        int matrixRows = matrix.length;
        int matrixCols = matrix[0].length;

        System.out.println(matrixRows);
        System.out.println(matrixCols);
        System.out.println(sum);
    }
}
