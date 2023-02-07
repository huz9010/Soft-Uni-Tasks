package ExamFeb2022;

import java.util.HashMap;
import java.util.Scanner;

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

        HashMap<Integer, Integer> chessboardNumbers = new HashMap<>();
        chessboardNumbers.put(0, 8);
        chessboardNumbers.put(1, 7);
        chessboardNumbers.put(2, 6);
        chessboardNumbers.put(3, 5);
        chessboardNumbers.put(4, 4);
        chessboardNumbers.put(5, 3);
        chessboardNumbers.put(6, 2);
        chessboardNumbers.put(7, 1);

        int moves = 1;


        while (true)    {

            if (moves % 2 != 0) {

                if (checkLeftDiagonal(chessboard, wPawnRow, wPawnCol, "b") || checkRightDiagonal(chessboard, wPawnRow,  wPawnCol, "b"))   {
                    System.out.printf("Game over! White capture on %s%d.", chessboardLetters.get(bPawnCol), chessboardNumbers.get(bPawnRow));
                    break;
                }   else {
                    chessboard[wPawnRow][wPawnCol] = "-";
                    wPawnRow--;
                    chessboard[wPawnRow][wPawnCol] = "w";

                    if (whitePawnQueen(wPawnRow, wPawnCol, chessboardLetters)) break;
                }
            }   else {

                if (checkLeftDiagonal(chessboard, bPawnRow, bPawnCol, "w") || checkRightDiagonal(chessboard, bPawnRow, wPawnCol, "w"))   {
                    System.out.printf("Game over! Black capture on %s%d.", chessboardLetters.get(wPawnCol), chessboardNumbers.get(wPawnRow));
                    break;
                }   else {
                    chessboard[bPawnRow][bPawnCol] = "-";
                    bPawnRow++;
                    chessboard[bPawnRow][bPawnCol] = "b";

                    if (blackPawnQueen(chessboard, bPawnRow, bPawnCol, chessboardLetters)) break;
                }
            }
            moves++;
        }
    }

    private static boolean blackPawnQueen(String[][] chessboard, int bPawnRow, int bPawnCol, HashMap<Integer, String> chessboardLetters) {
        if (bPawnRow == chessboard.length - 1)  {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s1.", chessboardLetters.get(bPawnCol));
            return true;
        }
        return false;
    }

    private static boolean whitePawnQueen(int wPawnRow, int wPawnCol, HashMap<Integer, String> chessboardLetters) {
        if (wPawnRow == 0)  {
            System.out.printf("Game over! White pawn is promoted to a queen at %s8.", chessboardLetters.get(wPawnCol));
            return true;
        }
        return false;
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
