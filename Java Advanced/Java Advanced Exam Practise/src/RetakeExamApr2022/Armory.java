package RetakeExamApr2022;

import java.util.Arrays;
import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] armory = new String[size][size];

        for (int r = 0; r < armory.length; r++) {
            armory[r] = scanner.nextLine().split("");
        }
        int[] officerPosition = getElementPosition(armory, "A");
        int officersRow = officerPosition[0];
        int officersCol = officerPosition[1];
        int totalSwordCost = 0;

        while (totalSwordCost < 65)   {
            String direction = scanner.nextLine();

            switch (direction)  {
                case "up":
                    clearField(officersCol, armory[officersRow]);
                    officersRow--;
                    break;
                case "down":
                    clearField(officersCol, armory[officersRow]);
                    officersRow++;
                    break;
                case "left":
                    clearField(officersCol, armory[officersRow]);
                    officersCol--;
                    break;
                case "right":
                    clearField(officersCol, armory[officersRow]);
                    officersCol++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction);
            }

            if (isOutOfArmory(armory, officersRow, officersCol))    {
                System.out.println("I do not need more swords!");
                break;

            } else if (armory[officersRow][officersCol].equalsIgnoreCase("M")) {
                clearField(officersCol, armory[officersRow]);
                int[] secondMirror = getElementPosition(armory, "M");
                int mirrorRow = secondMirror[0];
                int mirrorCol = secondMirror[1];
                officersRow = mirrorRow;
                officersCol = mirrorCol;
                clearField(mirrorCol, armory[mirrorRow]);

            } else if (Character.isDigit(armory[officersRow][officersCol].charAt(0))) {
                int price = Integer.parseInt(armory[officersRow][officersCol]);
                totalSwordCost += price;
                clearField(officersCol, armory[officersRow]);
            } else {
                clearField(officersCol, armory[officersRow]);
            }
        }

        if (totalSwordCost >= 65)   {
            armory[officersRow][officersCol] = "A";
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", totalSwordCost);

        Arrays.stream(armory).forEach(e -> System.out.println(String.join("", e)));
    }

    private static void clearField(int officersCol, String[] armory) {
        armory[officersCol] = "-";
    }


    private static boolean isOutOfArmory(String[][] armory , int r, int c) {
        return r < 0 || r >= armory.length || c < 0 || c >= armory[r].length;
    }

    private static int[] getElementPosition(String[][] armory, String element) {
        int row = -1;
        int col = -1;
        boolean isFound = false;
        for (int r = 0; r < armory.length; r++) {
            for (int c = 0; c < armory[r].length; c++) {
               if (armory[r][c].equalsIgnoreCase(element))  {
                   row = r;
                   col = c;
                   isFound = true;
                   break;
               }
               if (isFound) break;
            }
        }
        return new int[]{row,col};
    }
}
