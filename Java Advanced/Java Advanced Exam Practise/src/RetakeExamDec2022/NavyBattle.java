package RetakeExamDec2022;

import java.util.Arrays;
import java.util.Scanner;


public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] battlefield = new String[n][n];

        for (int r = 0; r < n; r++) {
            battlefield[r] = scanner.nextLine().split("");
        }

        int battleCruisers = getBattleCruisersCount(battlefield);
        int submarineHealth = 3;

        int submarineRow = findSubmarineLocation(battlefield)[0];
        int submarineCol = findSubmarineLocation(battlefield)[1];

        boolean isSubmarineDefeated = false;
        boolean isMissionSuccessful = false;

        while (!isSubmarineDefeated && !isMissionSuccessful)    {
            String direction = scanner.nextLine();
            switch (direction)  {
                case "up":
                    battlefield[submarineRow][submarineCol] = "-";
                    submarineRow--;

                    break;
                case "down":
                    battlefield[submarineRow][submarineCol] = "-";
                    submarineRow++;

                    break;
                case "left":
                    battlefield[submarineRow][submarineCol] = "-";
                    submarineCol--;

                    break;
                case "right":
                    battlefield[submarineRow][submarineCol] = "-";
                    submarineCol++;

                    break;
                default:
                    throw new  IllegalArgumentException("Invalid direction: " + direction);
            }

            if (battlefield[submarineRow][submarineCol].equals("*"))    {
                battlefield[submarineRow][submarineCol] = "-";
                submarineHealth -= 1;
                if (submarineHealth == 0)   {
                    isSubmarineDefeated = true;
                }
            } else if (battlefield[submarineRow][submarineCol].equals("C")) {
                battlefield[submarineRow][submarineCol] = "-";
                battleCruisers--;
                if (battleCruisers == 0)    {
                    isMissionSuccessful = true;
                }
            }
        }

        battlefield[submarineRow][submarineCol] = "S";
        if (isMissionSuccessful)    {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }   else {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
        }

        Arrays.stream(battlefield).forEach(e -> System.out.println(String.join("", e)));
    }

    private static int getBattleCruisersCount(String[][] battlefield) {
        int count = 0;
        for (int r = 0; r < battlefield.length; r++) {
            for (int c = 0; c < battlefield.length; c++) {
                if (battlefield[r][c].equals("C"))  {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] findSubmarineLocation(String[][] battlefield) {
        boolean isFound = false;
        int submarineCol = -1;
        int submarineRow = -1;
        for (int r = 0; r < battlefield.length; r++) {
            for (int c = 0; c < battlefield.length; c++) {
                if (battlefield[r][c].equals("S"))  {
                    submarineRow = r;
                    submarineCol = c;
                    isFound = true;
                    break;
                }
                if (isFound) {
                    break;
                }
            }
        }
        return new int[]{submarineRow, submarineCol};
    }
}
