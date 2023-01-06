package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);

        int[][] matrix = new int[size][size];


        switch (pattern) {
            case 'A':
                matrix = fillPatternA(size);
                break;
            case 'B':
                matrix = fillPatternB(size);
                break;
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] fillPatternA(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = counter;
                counter++;
            }
        }
        return matrix;
    }


    public static int[][] fillPatternB(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;
        for (int c = 0; c < matrix.length; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = counter;
                    counter++;
                }
            } else {
                for (int r = matrix.length - 1; r >= 0; r--) {
                    matrix[r][c] = counter;
                    counter++;
                }
            }
        }
        return matrix;
    }
}
