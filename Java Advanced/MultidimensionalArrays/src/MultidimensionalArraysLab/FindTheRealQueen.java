package MultidimensionalArraysLab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];

        for (int r = 0; r < chessBoard.length; r++) {
            chessBoard[r] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        int[] validQueenPosition = findValidQueen(chessBoard);
        for (int i : validQueenPosition) {
            System.out.print(i + " ");
        }
    }

    private static int[] findValidQueen(char[][] chessBoard) {
        int[] validQueenPosition = new int[2];

        for (int r = 0; r < chessBoard.length; r++) {
            for (int c = 0; c < chessBoard[r].length; c++) {
                boolean isValidQueen = true;
                if (chessBoard[r][c] == 'q')    {
                    int row = 0;

                    while (row < chessBoard.length - 1) {
                        if (chessBoard[row][c] == 'q' && row != r)  {
                            isValidQueen = false;
                            break;
                        }
                        row++;
                    }

                    if (!isValidQueen)  {
                        break;
                    }

                    int col = 0;

                    while (col < chessBoard[r].length - 1) {
                        if (chessBoard[r][col] == 'q' && col != c)  {
                            isValidQueen = false;
                            break;
                        }
                        col++;
                    }

                    if (!isValidQueen) {
                        break;
                    }

                    row = r;
                    col = c;
                    while (row > 0 && col > 0) {
                        if (chessBoard[row][col] == 'q' && row != r && col != c)  {
                            isValidQueen = false;
                            break;
                        }
                        row--;
                        col--;
                    }

                    if (!isValidQueen) {
                        break;
                    }

                    row = r;
                    col = c;
                    while (row > chessBoard[r].length - 1 && col > chessBoard[r].length - 1) {
                        if (chessBoard[row][col] == 'q' && row != r && col != c)  {
                            isValidQueen = false;
                            break;
                        }
                        row++;
                        col++;
                    }

                    if (!isValidQueen) {
                        break;
                    }

                    row = r;
                    col = c;
                    while (row < chessBoard[r].length - 1 && col > 0) {
                        if (chessBoard[row][col] == 'q' && row != r && col != c)  {
                            isValidQueen = false;
                            break;
                        }
                        row++;
                        col--;
                    }

                    if (!isValidQueen) {
                        break;
                    }

                    row = r;
                    col = c;
                    while (row > 0 && col < chessBoard.length - 1) {
                        if (chessBoard[row][col] == 'q' && row != r && col != c)  {
                            isValidQueen = false;
                            break;
                        }
                        row--;
                        col++;
                    }

                    if (isValidQueen)   {
                        validQueenPosition[0] = r;
                        validQueenPosition[1] = c;
                        break;
                    }
                }
            }
        }
        return validQueenPosition;
    }
}
