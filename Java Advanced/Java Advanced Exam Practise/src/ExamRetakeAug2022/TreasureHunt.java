package ExamRetakeAug2022;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fieldSize = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(fieldSize[0]);
        int cols = Integer.parseInt(fieldSize[1]);

        String[][] field = new String[rows][cols];

        for (int r = 0; r < field.length; r++) {
            field[r] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();
        int[] yourPosition = getYourPosition(field);
        int yourRow = yourPosition[0];
        int yourCol = yourPosition[1];

        ArrayDeque<String> route = new ArrayDeque<>();

        while (!input.equals("Finish")) {
            int nextRow = -1;
            int nexCol = -1;

            switch (input)  {
                case "up":
                    nextRow = yourRow - 1;
                    nexCol = yourCol;
                    break;
                case "down":
                    nextRow = yourRow + 1;
                    nexCol = yourCol;
                    break;
                case "left":
                    nextRow = yourRow;
                    nexCol = yourCol - 1;
                    break;
                case "right":
                    nextRow = yourRow;
                    nexCol = yourCol + 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + input);
            }

            if (isValidDirection(field, nextRow, nexCol))  {
                yourRow = nextRow;
                yourCol = nexCol;
                route.offer(input);
            }

            input = scanner.nextLine();
        }

        boolean treasureFound = field[yourRow][yourCol].equalsIgnoreCase("X");

        if (!treasureFound) {
            System.out.println("The map is fake!");
        }   else {
            System.out.println("I've found the treasure!");
            String path = String.join(", ", route);
            System.out.println("The right path is " + path);
        }

    }



    private static boolean isValidDirection(String[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length && !field[r][c].equalsIgnoreCase("T");
    }

    private static int[] getYourPosition(String[][] field) {
        boolean positionFound = false;
        int yourRow = -1;
        int yourCol = -1;
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c].equalsIgnoreCase("Y"))  {
                    yourRow = r;
                    yourCol = c;
                    positionFound = true;
                    break;
                }
                if (positionFound)  {
                    break;
                }
            }
        }
        return new int[]{yourRow, yourCol};
    }
}
