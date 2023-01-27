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
        chessboardLetters.put(1, "a");
        chessboardLetters.put(2, "b");
        chessboardLetters.put(3, "c");
        chessboardLetters.put(4, "d");
        chessboardLetters.put(5, "e");
        chessboardLetters.put(6, "f");
        chessboardLetters.put(7, "g");
        chessboardLetters.put(8, "h");

        int moves = 1;

        while (bPawnRow > 1 && wPawnRow < 8)    {

            if (moves % 2 != 0) {

                if (checkLeftDiagonal(chessboard, wPawnRow, wPawnCol, "b") || checkRightDiagonal(chessboard, wPawnRow, wPawnCol, "b"))   {
                    System.out.printf("Game over! White capture on %d%s.", wPawnRow, chessboardLetters.get(wPawnCol));

                }   else {
                    wPawnRow++;
                }
            }   else {

                if (checkLeftDiagonal(chessboard, bPawnRow, wPawnCol, "w") || checkRightDiagonal(chessboard, bPawnRow, wPawnCol, "w"))   {
                    System.out.printf("Game over! Black capture on %d%s.", bPawnRow, chessboardLetters.get(bPawnCol));
                    break;
                }   else {
                    bPawnRow--;
                }
            }
            moves++;
        }
    }

    private static boolean checkRightDiagonal(String[][] chessboard, int pawnRow, int pawnCol, String color) {
        if (color.equals("b")) {
            return chessboard[pawnRow + 1][pawnCol + 1].equals(color);
        } else  return chessboard[pawnRow - 1][pawnCol + 1].equals(color);
    }

    private static boolean checkLeftDiagonal(String[][] chessboard, int pawnRow, int pawnCol, String color) {
        if (color.equals("b"))  {
            return chessboard[pawnRow + 1][pawnCol - 1].equals(color);
        }   else {
            return chessboard[pawnRow - 1][pawnCol - 1].equals(color);
        }
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
}
