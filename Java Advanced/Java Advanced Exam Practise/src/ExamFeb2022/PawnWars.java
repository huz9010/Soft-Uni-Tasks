package ExamFeb2022;

import java.util.HashMap;
import java.util.Scanner;

// TO DO: make black and white pawns move on chessboard!!!


public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessboard = new String[8][8];

        for (int r = 0; r < chessboard.length; r++) {
            chessboard[r] = scanner.nextLine().split("");
        }

        int[] blackPawnPosition = getPawnPosition(chessboard, "b");
        int[] whitePawnPosition = getPawnPosition(chessboard, "w");

        int bPawnRow = blackPawnPosition[0];
        int bPawnCol = blackPawnPosition[1];
        int wPawnRow = whitePawnPosition[0];
        int wPawnCol = whitePawnPosition[1];

        HashMap<Integer, String> chessboardLetters = new HashMap<>();
        chessboardLetters.put(0, "a");
        chessboardLetters.put(1, "b");
        chessboardLetters.put(2, "c");
        chessboardLetters.put(3, "d");
        chessboardLetters.put(4, "e");
        chessboardLetters.put(5, "f");
        chessboardLetters.put(6, "g");
        chessboardLetters.put(7, "h");

        int moves = 1;


        while (bPawnRow < chessboard.length - 1 && wPawnRow > 0)    {

            if (moves % 2 != 0) {

                if (checkLeftDiagonal(chessboard, wPawnRow, wPawnCol, "b") || checkRightDiagonal(chessboard, wPawnRow,  wPawnCol, "b"))   {
                    System.out.printf("Game over! White capture on %s%d.", chessboardLetters.get(bPawnCol), chessboard.length - wPawnRow + 1);
                    break;
                }   else {
                    wPawnRow--;

                    if (wPawnRow == 0)  {
                        System.out.printf("Game over! White pawn is promoted to a queen at %s8.", chessboardLetters.get(wPawnCol));
                        break;
                    }
                }
            }   else {

                if (checkLeftDiagonal(chessboard, bPawnRow, wPawnCol, "w") || checkRightDiagonal(chessboard, bPawnRow, wPawnCol, "w"))   {
                    System.out.printf("Game over! Black capture on %s%d.", chessboardLetters.get(wPawnCol), chessboard.length - wPawnRow + 1);
                    break;
                }   else {
                    bPawnRow++;

                    if (bPawnRow == chessboard.length - 1)  {
                        System.out.printf("Game over! Black pawn is promoted to a queen at %s8.", chessboardLetters.get(bPawnCol));
                        break;
                    }
                }
            }
            moves++;
        }
    }

    private static boolean checkRightDiagonal(String[][] chessboard, int pawnRow, int pawnCol, String color) {
        if (color.equals("b")) {
            if (isValidCell(chessboard, pawnRow - 1, pawnCol + 1)) {
                return chessboard[pawnRow - 1][pawnCol + 1].equals(color);
            }
        } else  {
            if (isValidCell(chessboard, pawnRow + 1, pawnCol + 1)) {
                return chessboard[pawnRow + 1][pawnCol + 1].equals(color);
            }
        }
        return false;
    }

    private static boolean checkLeftDiagonal(String[][] chessboard, int pawnRow, int pawnCol, String color) {
        if (color.equals("b"))  {
            if (isValidCell(chessboard, pawnRow - 1, pawnCol - 1)) {
                return chessboard[pawnRow - 1][pawnCol - 1].equals(color);
            }
        }   else {
            if (isValidCell(chessboard, pawnRow + 1, pawnCol - 1)) {
                return chessboard[pawnRow + 1][pawnCol - 1].equals(color);
            }
        }
        return false;
    }

    private static int[] getPawnPosition(String[][] chessboard, String color) {
        int row = -1;
        int col = -1;
        boolean isFound = false;

        for (int r = 0; r < chessboard.length; r++) {
            for (int c = 0; c < chessboard[r].length; c++) {
                if (chessboard[r][c].equals(color)) {
                    row = r;
                    col = c;
                    isFound = true;
                    break;
                }
                if (isFound) {
                    break;
                }
            }
        }
        return new int[]{row, col};
    }

    private static boolean isValidCell(String[][] chessboard, int r, int c) {
        return r >= 0 && r < chessboard.length && c >= 0 && c < chessboard[r].length;
    }
}
