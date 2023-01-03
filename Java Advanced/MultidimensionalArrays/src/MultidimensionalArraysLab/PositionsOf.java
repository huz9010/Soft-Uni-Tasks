package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int [][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int numberToCheck = scanner.nextInt();

        List<int[]> positions = checkNumber(matrix, numberToCheck);

        if (positions.isEmpty())    {
            System.out.println("not found");
        }   else {
            for (int[] position : positions) {
                System.out.println(Arrays.toString(position).replaceAll("[\\[,\\]]", ""));
            }
        }
    }


    private static List<int[]> checkNumber (int[][] matrix, int numberToCheck) {
        List<int[]> positions = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == numberToCheck)  {
                    int [] arr = {r, c};
                    positions.add(arr);
                }
            }
        }
        return positions;
    }
}
