package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chamber = new String[15][15];

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000;
        int[] playerPosition = {7, 7};

        for (String[] strings : chamber) {
            Arrays.fill(strings, "clear");
        }
        String spell = "";
        boolean playerIsHit = false;

        while (heiganHitPoints > 0 && playerHitPoints > 0) {
            heiganHitPoints -= damageToHeigan;

            if (spell.equals("Cloud") && playerIsHit)  {
                playerHitPoints -= 3500;
            }

            if (isDead(heiganHitPoints) || isDead(playerHitPoints))    {
                break;
            }

            playerIsHit = false;
            String input = scanner.nextLine();
            spell = input.split("\\s+")[0];
            int r = Integer.parseInt(input.split("\\s+")[1]);
            int c = Integer.parseInt(input.split("\\s+")[2]);

            if (isValidIndexForSpell(r, c)) {

                castSpell(spell, r, c, chamber);

                if (isValidIndexForPlayer(playerPosition[0] - 1, playerPosition[1], chamber))   {
                    playerPosition[0]--;
                } else if (isValidIndexForPlayer(playerPosition[0], playerPosition[1] + 1, chamber)) {
                    playerPosition[1]++;
                } else if (isValidIndexForPlayer(playerPosition[0] + 1, playerPosition[1], chamber)) {
                    playerPosition[0]++;
                } else if (isValidIndexForPlayer(playerPosition[0], playerPosition[1] - 1, chamber)) {
                    playerPosition[1]--;
                }   else {
                    playerIsHit = true;
                    playerHitPoints = (spell.equals("Cloud") ? playerHitPoints - 3500 : playerHitPoints - 6000);
                }
            }
            clearSpell(r,c, chamber);
        }
        if (spell.equals("Cloud"))  {
            spell = "Plague Cloud";
        }

        System.out.printf(isDead(heiganHitPoints) ? "Heigan: Defeated!%n" : "Heigan: %.2f%n", heiganHitPoints);
        System.out.println(isDead(playerHitPoints) ? "Player: Killed by " + spell : "Player: " + playerHitPoints);
        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
        }



    public static boolean isValidIndexForSpell(int r, int c) {
        return r >= 0 && r <= 14 && c >= 0 && c <= 14;
    }

    public static boolean isValidIndexForPlayer(int r, int c, String[][] chamber) {
        return (r >= 0) && (r <= 14) && (c >= 0) && (c <= 14) && (chamber[r][c].equals("clear"));
    }

    public static boolean isDead (double hitPoints)    {
        return hitPoints <= 0;
    }

    public static void castSpell (String spell, int r, int c, String[][] chamber) {
        r--;
        c--;

        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                if (isValidIndexForSpell(row, col)) {
                    chamber[row][col] = spell;
                }
            }
        }
    }

    public static void clearSpell (int r, int c, String[][] chamber) {
        r--;
        c--;

        for (int row = r; row < r + 3; row++) {
            for (int col = c; col < c + 3; col++) {
                if (isValidIndexForSpell(row, col)) {
                    chamber[row][col] = "clear";
                }
            }
        }
    }
}
