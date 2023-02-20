import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] playground = new String[rows][cols];

        for (int r = 0; r < playground.length; r++) {
            playground[r] = scanner.nextLine().split("\\s+");
        }

        int[] playerPosition = findPlayer(playground);
        int pRow =  playerPosition[0];
        int pCol =  playerPosition[1];

        int moves = 0;
        int touchedOpponents = 0;

        String command = scanner.nextLine();

        while (!command.equals("Finish"))    {

            switch (command)    {
                case "up":
                    if (isValidDirection(playground, pRow - 1, pCol))   {
                        pRow -= 1;
                        moves++;
                        if (isOpponent(playground, pRow, pCol)) {
                            playground[pRow][pCol] = "-";
                            touchedOpponents++;
                        }
                    }
                    break;
                case "down":
                    if (isValidDirection(playground, pRow + 1, pCol))   {
                        pRow += 1;
                        moves++;
                        if (isOpponent(playground, pRow, pCol)) {
                            playground[pRow][pCol] = "-";
                            touchedOpponents++;
                        }
                    }
                    break;
                case "left":
                    if (isValidDirection(playground, pRow, pCol - 1))   {
                        pCol -= 1;
                        moves++;
                        if (isOpponent(playground, pRow, pCol)) {
                            playground[pRow][pCol] = "-";
                            touchedOpponents++;
                        }
                    }
                    break;
                case "right":
                    if (isValidDirection(playground, pRow, pCol + 1))   {
                        pCol += 1;
                        moves++;
                        if (isOpponent(playground, pRow, pCol)) {
                            playground[pRow][pCol] = "-";
                            touchedOpponents++;
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + command);
            }

            if (touchedOpponents == 3)  {
                break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.print("Touched opponents: " + touchedOpponents);
        System.out.println(" Moves made: " + moves);
    }


    private static boolean isOpponent(String[][] playground, int r, int c) {
        return playground[r][c].equals("P");
    }

    private static boolean isValidDirection(String[][] playground, int r, int c) {
        return r >= 0 && r < playground.length && c >= 0 && c < playground[r].length && !playground[r][c].equals("O");
    }

    private static int[] findPlayer(String[][] playground) {
        for (int r = 0; r < playground.length; r++) {
            for (int c = 0; c < playground[r].length; c++) {
                if (playground[r][c].equals("B"))   {
                    return new int[]{r, c};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
