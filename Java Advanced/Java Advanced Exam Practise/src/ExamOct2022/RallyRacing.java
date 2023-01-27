package ExamOct2022;

import java.util.Arrays;
import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String tracedCarNumber = scanner.nextLine();
        String[][] track = new String[size][size];

        for (int r = 0; r < size; r++) {
            track[r] = scanner.nextLine().split("\\s+");
        }

        int carRow = 0;
        int carCol = 0;
        int distance = 0;
        boolean isFinished = false;

        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            switch (input)  {
                case "up":
                    track[carRow][carCol] = ".";
                    carRow--;
                    break;
                case "down":
                    track[carRow][carCol] = ".";
                    carRow++;
                    break;
                case "left":
                    track[carRow][carCol] = ".";
                    carCol--;
                    break;
                case "right":
                    track[carRow][carCol] = ".";
                    carCol++;
                    break;
                    default:
                        throw new IllegalArgumentException("Invalid direction: " + input);
            }

            if (track[carRow][carCol].equals("T"))  {
                track[carRow][carCol] = ".";
                carRow = getTunnelExit(track)[0];
                carCol = getTunnelExit(track)[1];
                track[carRow][carCol] = ".";
                distance += 30;
            } else if (track[carRow][carCol].equals("F")) {
                distance += 10;
                isFinished = true;
            }   else {
                distance += 10;
            }

            if (isFinished) {
                break;
            }

            input = scanner.nextLine();
        }
        track[carRow][carCol] = "C";

        if (isFinished)    {
            System.out.printf("Racing car %s finished the stage!%n", tracedCarNumber);
        }   else {
            System.out.printf("Racing car %s DNF.%n", tracedCarNumber);
        }

        System.out.printf("Distance covered %d km.%n", distance);
        Arrays.stream(track).forEach(e -> System.out.println(String.join("",e)));
    }

    private static int[] getTunnelExit(String[][] track) {
        int row = -1;
        int col = -1;
        boolean exitFound = false;
        for (int r = 0; r < track.length; r++) {
            for (int c = 0; c < track[r].length; c++) {
                if (track[r][c].equals("T")) {
                    row = r;
                    col = c;
                    exitFound = true;
                    break;
                }
                if (exitFound)  {
                    break;
                }
            }
        }
        return new int[]{row, col};
    }
}
