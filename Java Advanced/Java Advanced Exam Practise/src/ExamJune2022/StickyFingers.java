package ExamJune2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> commands = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",")).forEach(commands::offer);

        String[][] field = new String[size][size];

        for (int r = 0; r < field.length; r++) {
            field[r] = scanner.nextLine().split("\\s+");
        }

        int[] dPosition = getDillingerPosition(field);
        int dRow = dPosition[0];
        int dCol = dPosition[1];

        int totalMoney = 0;
        boolean isCaught = false;

        while (!commands.isEmpty()) {
            String command = commands.poll();
            int nextRow = -1;
            int nexCol = -1;

            switch (command) {
                case "up":
                    nextRow = dRow - 1;
                    nexCol = dCol;
                    break;
                case "down":
                    nextRow = dRow + 1;
                    nexCol = dCol;
                    break;
                case "left":
                    nextRow = dRow;
                    nexCol = dCol - 1;
                    break;
                case "right":
                    nextRow = dRow;
                    nexCol = dCol + 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + command);
            }

            if (isValidDirection(field, nextRow, nexCol)) {
                field[dRow][dCol] = "+";
                dRow = nextRow;
                dCol = nexCol;

                if (field[dRow][dCol].equalsIgnoreCase("$")) {
                    totalMoney += dRow * dCol;
                    field[dRow][dCol] = "+";
                    System.out.printf("You successfully stole %d$.%n", (dRow * dCol));
                    field[dRow][dCol] = "D";
                } else if (field[dRow][dCol].equalsIgnoreCase("P")) {
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                    field[dRow][dCol] = "#";
                    isCaught = true;
                    break;
                }   else {
                    field[dRow][dCol] = "D";
                }

            } else {
                System.out.println("You cannot leave the town, there is police outside!");
            }
        }

        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        }

        Arrays.stream(field).forEach(e -> System.out.println(String.join(" ", e)));
    }



    private static boolean isValidDirection(String[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static int[] getDillingerPosition(String[][] field) {
        boolean positionFound = false;
        int dRow = -1;
        int dCol = -1;
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c].equalsIgnoreCase("D"))  {
                    dRow = r;
                    dCol = c;
                    positionFound = true;
                    break;
                }
                if (positionFound)  {
                    break;
                }
            }
        }
        return new int[]{dRow, dCol};
    }
}

