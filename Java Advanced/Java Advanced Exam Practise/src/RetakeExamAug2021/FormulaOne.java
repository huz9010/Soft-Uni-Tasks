package RetakeExamAug2021;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int commandCount = Integer.parseInt(scanner.nextLine());

        char[][] track = new char[rows][];

        for (int r = 0; r < rows; r++) {
            track[r] = scanner.nextLine().toCharArray();
        }

        int[] playerPosition = findPlayer(track);
        assert playerPosition != null;
        int pRow = playerPosition[0];
        int pCol = playerPosition[1];

        boolean hasWon = false;

        String direction = scanner.nextLine();
        for (int i = 1; i <= commandCount; i++) {
            int nextRow = -1;
            int nextCol = -1;

            switch (direction)    {
                case "up":
                    nextRow = pRow - 1;
                    nextCol = pCol;
                    break;
                case "down":
                    nextRow = pRow + 1;
                    nextCol = pCol;
                    break;
                case "left":
                    nextRow = pRow;
                    nextCol = pCol - 1;
                    break;
                case "right":
                    nextRow = pRow;
                    nextCol = pCol + 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction);
            }

            nextRow = checkNextRow(nextRow, track);
            nextCol = checkNextCol(nextCol, track);

            if (track[nextRow][nextCol] == 'T')     {
                direction = scanner.nextLine();
                continue;
            }

            if (track[nextRow][nextCol] == 'B') {
                track[pRow][pCol] = '.';
                pRow = nextRow;
                pCol = nextCol;
                i--;
                continue;
            }

            if (track[nextRow][nextCol] == 'F')     {
                track[pRow][pCol] = '.';
                pRow = nextRow;
                pCol = nextCol;
                track[pRow][pCol] = 'P';
                hasWon = true;
                break;
            }

            if (track[pRow][pCol] != 'B') {
                track[pRow][pCol] = '.';
            }
            pRow = nextRow;
            pCol = nextCol;
            track[pRow][pCol] = 'P';

            if (i >= commandCount)  {
                break;
            }
            direction = scanner.nextLine();
        }

        System.out.println(hasWon ? "Well done, the player won first place!" : "Oh no, the player got lost on the track!");

        for (char[] line : track)   {
            for (char cell : line)  {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static int checkNextCol(int nextCol, char[][] track) {
        if (nextCol < 0)    {
            nextCol = track.length - 1;
        } else if (nextCol >= track.length) {
            nextCol = 0;
        }
        return nextCol;
    }

    private static int checkNextRow(int nextRow, char[][] track) {
        if (nextRow < 0)    {
            nextRow = track.length - 1;
        } else if (nextRow >= track.length) {
            nextRow = 0;
        }
        return nextRow;
    }


    private static int[] findPlayer(char[][] track) {
        for (int r = 0; r < track.length; r++) {
            for (int c = 0; c < track[r].length; c++) {
                if (track[r][c] == 'P') {
                    return new int[] {r, c};
                }
            }
        }
        return null;
    }
}
