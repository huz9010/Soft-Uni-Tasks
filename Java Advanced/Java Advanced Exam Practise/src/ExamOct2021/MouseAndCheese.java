package ExamOct2021;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[rows][];

        for (int r = 0; r < rows; r++) {
            territory[r] = scanner.nextLine().toCharArray();
        }

        int[] mousePosition = findMouse(territory);
        assert mousePosition != null;
        int mRow = mousePosition[0];
        int mCol = mousePosition[1];
        String command = scanner.nextLine();

        boolean isMouseOut = false;
        int cheeseEaten = 0;

        while (!command.equals("end"))   {

            int nextRow = -1;
            int nextCol = -1;

            switch (command)    {

                case "up":
                    nextRow = mRow - 1;
                    nextCol = mCol;
                    break;
                case "down":
                    nextRow = mRow + 1;
                    nextCol = mCol;
                    break;
                case "left":
                    nextRow = mRow;
                    nextCol = mCol - 1;
                    break;
                case "right":
                    nextRow = mRow;
                    nextCol = mCol + 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + command);
            }

            if (!isValidIndex(nextRow, nextCol, territory)) {
                isMouseOut = true;
                territory[mRow][mCol] = '-';
                break;
            }

            if (isCheese(nextRow, nextCol, territory))  {
                cheeseEaten++;
            }

            if (isBonus(nextRow, nextCol, territory))   {
                territory[mRow][mCol] = '-';
                territory[nextRow][nextCol] = 'M';
                mRow = nextRow;
                mCol = nextCol;
                continue;
            }

            territory[mRow][mCol] = '-';
            mRow = nextRow;
            mCol = nextCol;
            territory[mRow][mCol] = 'M';

            command = scanner.nextLine();
        }

        if (isMouseOut) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten < 5)   {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }   else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        for (char[] line : territory)   {
            for (char cell : line)  {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static boolean isBonus(int r, int c, char[][] territory) {
        return territory[r][c] == 'B';
    }

    private static boolean isCheese(int r, int c, char[][] territory) {
        return territory[r][c] == 'c';
    }

    private static boolean isValidIndex(int r, int c, char[][] territory) {
        return r >= 0 && r < territory.length && c >= 0 && c < territory[r].length;
    }

    private static int[] findMouse(char[][] territory) {
        boolean isFound = false;

        for (int r = 0; r < territory.length; r++) {
            for (int c = 0; c < territory[r].length; c++) {
                if (territory[r][c] == 'M')  {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }
}
