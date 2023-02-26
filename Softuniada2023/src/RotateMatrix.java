import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        fillTheMatrix(scanner, matrix);

        printMatrix(rotateMatrix90(matrix));

    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(Scanner scanner, int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }

    private static int[][] rotateMatrix90(int[][] matrix) {
        int size = matrix.length;

        int[][] rotatedMatrix = new int[size][size];

        int matrixCol = 0;

        for (int r = 0; r < rotatedMatrix.length; r++) {
            int matrixRow = matrix.length - 1;
            for (int c = 0; c < rotatedMatrix.length; c++) {
                rotatedMatrix[r][c] = matrix[matrixRow][matrixCol];
                matrixRow--;
            }
            matrixCol++;
        }
        return rotatedMatrix;
    }
}
