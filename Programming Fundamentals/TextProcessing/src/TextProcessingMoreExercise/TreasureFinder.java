package TextProcessingMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("find"))   {
            StringBuilder inputString = new StringBuilder(input);
            StringBuilder changedInput = new StringBuilder();

                for (int j = 0; j < key.length; j++) {
                    if (inputString.length() == 0)  {
                        break;
                    }
                    char tempChar = (char) ((int) inputString.charAt(0) - key[j]);
                    changedInput.append(tempChar);
                    inputString.deleteCharAt(0);

                    if (j == key.length - 1 && inputString.length() > 0)  {
                        j = -1;
                    }
            }
            int firstTreasureIndex = changedInput.indexOf("&");
            int lastTreasureIndex = changedInput.lastIndexOf("&");
            int firstCoordinatesIndex = changedInput.lastIndexOf("<");
            int lastCoordinatesIndex = changedInput.lastIndexOf(">");

            String treasure = changedInput.substring(firstTreasureIndex + 1, lastTreasureIndex);
            String coordinates = changedInput.substring(firstCoordinatesIndex + 1, lastCoordinatesIndex);

            System.out.printf("Found %s at %s%n", treasure, coordinates);
            input = scanner.nextLine();
        }
    }
}
