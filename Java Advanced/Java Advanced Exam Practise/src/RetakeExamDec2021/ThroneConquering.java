package RetakeExamDec2021;

import java.util.Arrays;
import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] city = new char[rows][];

        for (int row = 0; row < rows; row++) {
            city[row] = scanner.nextLine().toCharArray();
        }

        int[] parisPosition = findPerson(city, 'P');
        int pRow = parisPosition[0];
        int pCol = parisPosition[1];
        int[] helenPosition = findPerson(city, 'H');
        int hRow = helenPosition[0];
        int hCol = helenPosition[1];

        boolean reachedHelen = false;

        String[] input = scanner.nextLine().split("\\s+");
        while (energy > 0) {
            String direction = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);

            city[spartanRow][spartanCol] = 'S';

            int nextRow = -1;
            int nextCol = -1;

            switch (direction) {
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

            energy--;
            if (!isValid(nextRow, nextCol, city)) {
                input = scanner.nextLine().split("\\s+");
                continue;
            }

            if (city[nextRow][nextCol] == 'S') {
                energy -= 2;
                city[pRow][pCol] = '-';

                if (energy <= 0) {
                    city[nextRow][nextCol] = 'X';
                    pRow = nextRow;
                    pCol = nextCol;
                    break;
                } else {
                    pRow = nextRow;
                    pCol = nextCol;
                    city[pRow][pCol] = 'P';
                }
            } else if (city[nextRow][nextCol] == 'H') {
                reachedHelen = true;
                city[nextRow][nextCol] = '-';
                city[pRow][pCol] = '-';
                break;
            } else {
                city[pRow][pCol] = '-';
                pRow = nextRow;
                pCol = nextCol;
                city[pRow][pCol] = 'P';
                if (energy <= 0) {
                    city[pRow][pCol] = 'X';
                    break;
                }
            }

            input = scanner.nextLine().split("\\s+");
        }

        if (reachedHelen) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }   else {
            System.out.printf("Paris died at %d;%d.%n", pRow, pCol);
        }
        for (char[] line : city) {
            for (char cell : line) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }


    private static boolean isValid(int r, int c, char[][] city) {
        return r >= 0 && r < city.length && c >= 0 && c < city[r].length;
    }

    private static int[] findPerson(char[][] city, char firstLetter) {
        int[] parisPosition = new int[2];
        boolean isFound = false;
        for (int row = 0; row < city.length; row++) {
            for (int col = 0; col < city[row].length; col++) {
                if (city[row][col] == firstLetter)  {
                    parisPosition = new int[]{row, col};
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return parisPosition;
    }
}
