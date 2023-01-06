package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine().split("[()]")[1]);

        String input = scanner.nextLine();
        List<String> wordList = new ArrayList<>();

        while (!input.equals("END"))    {
            wordList.add(input);
            input = scanner.nextLine();
        }

        int maxLength = 0;
        for (String s : wordList) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        char[][] matrix = new char[wordList.size()][maxLength];

        fillTheMatrix(wordList, matrix);

        int rotationCount = degrees / 90 - 1;

        if (rotationCount % 4 != 0) {
            printMatrix(rotateMatrix90(matrix, rotationCount));
        }   else {
            printMatrix(matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(List<String> wordList, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            String currentWord = wordList.get(r);
            for (int c = 0; c < matrix[r].length; c++) {
                if (c >= currentWord.length())  {
                    matrix[r][c] = ' ';
                }   else {
                    matrix[r][c] = currentWord.charAt(c);
                }
            }
        }
    }

    private static char[][] rotateMatrix90 (char[][] matrix, int rotationCount)    {
        int rows = matrix[0].length;
        int cols = matrix.length;

        char[][] rotatedMatrix = new char[rows][cols];

        int matrixCol = 0;

        for (int r = 0; r < rotatedMatrix.length; r++) {
            int matrixRow = matrix.length - 1;
            for (int c = 0; c < rotatedMatrix[r].length; c++) {
                rotatedMatrix[r][c] = matrix[matrixRow][matrixCol];
                matrixRow--;
            }
            matrixCol++;
        }

        while (rotationCount != 0)  {
            rotationCount--;
            rotateMatrix90(rotatedMatrix, rotationCount);

        }
        return rotatedMatrix;
    }
}
