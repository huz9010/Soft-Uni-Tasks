package MultidimensionalArraysLab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] firstMatrix = new int[rows][cols];

        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
        }

        rows = scanner.nextInt();
        cols = scanner.nextInt();

        int[][] secondMatrix = new int[rows][cols];
        for (int r = 0; r < secondMatrix.length; r++) {
            for (int c = 0; c < secondMatrix[r].length; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }
        }

        boolean areEqual = areEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    public static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length)  {
            return false;
        }

        for (int r = 0; r < firstMatrix.length; r++) {
            int[] firstArr = firstMatrix[r];
            int[] secondArr = secondMatrix[r];

            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int c = 0; c < firstArr.length; c++) {
                if (firstArr[c] != secondArr[c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
