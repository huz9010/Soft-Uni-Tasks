package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }
        int[] wrongValueIndexes = readArray(scanner);
        int wrongValue = matrix[wrongValueIndexes[0]][wrongValueIndexes[1]];

        List<int[]> trueValues = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue) {
                    int nearbySum = nearbySum(matrix, r, c, wrongValue);
                    trueValues.add(new int[]{r, c, nearbySum});
                }
            }
        }

        for (int[] value : trueValues) {
            matrix[value[0]][value[1]] = value[2];
        }

        for (int[] arrays : matrix) {
            for (int ints : arrays) {
                System.out.print(ints + " ");
            }
            System.out.println();
        }
    }



    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean isInBound (int r,int c, int[][] matrix)   {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    public static int nearbySum (int[][] matrix, int r, int c, int wrongValue)   {
        int sum = 0;

        if (isInBound(r - 1, c, matrix))    {
            if (matrix[r - 1][c] != wrongValue){
                sum += matrix[r - 1][c];
            }
        }
        if (isInBound(r + 1, c, matrix))    {
            if (matrix[r + 1][c] != wrongValue){
                sum += matrix[r + 1][c];
            }
        }
        if (isInBound(r, c - 1, matrix))    {
            if (matrix[r][c - 1] != wrongValue){
                sum += matrix[r][c - 1];
            }
        }
        if (isInBound(r, c + 1, matrix))    {
            if (matrix[r][c + 1] != wrongValue){
                sum += matrix[r][c + 1];
            }
        }
        return sum;
    }
}
