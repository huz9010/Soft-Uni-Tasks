package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readArr(scanner, rows, cols);
        char[][] secondMatrix = readArr(scanner, rows, cols);

        char[][] outputMatrix = compareMatrices(firstMatrix, secondMatrix);

        for (char[] chars : outputMatrix) {
            for (char ch : chars) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static char[][] readArr(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    public static char[][] compareMatrices (char[][] firstMatrix, char[][] secondMatrix)    {
        char[][]outputMatrix = new char[firstMatrix.length][firstMatrix[0].length];

        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {
                if (firstMatrix[r][c] == secondMatrix[r][c])    {
                    outputMatrix[r][c] = firstMatrix[r][c];
                }   else {
                    outputMatrix[r][c] = '*';
                }
            }
        }
        return outputMatrix;
    }
}
