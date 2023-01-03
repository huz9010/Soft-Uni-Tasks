package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int col = 0;
        List<Integer> firstDiagonal = new ArrayList<>();
        for (int[] ints : matrix) {
            firstDiagonal.add(ints[col]);
            col++;
        }

        col = 0;
        List<Integer> secondDiagonal = new ArrayList<>();
        for (int r = matrix.length - 1; r >= 0 ; r--) {
            secondDiagonal.add(matrix[r][col]);
            col++;
        }

        for (Integer ints : firstDiagonal) {
            System.out.print(ints + " ");
        }
        System.out.println();
        for (Integer ints : secondDiagonal) {
            System.out.print(ints + " ");
        }
    }
}
