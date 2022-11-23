package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dnaLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int[] bestDNA = new int[dnaLength];

        while (!input.equals("Clone them!"))    {
            int[] currentDNA = Arrays.stream(input.split("!")).mapToInt(Integer::parseInt).toArray();
            int bestDnaIndex = -1;
            int prevBestIndex = -1;
            int counter = 0;
            int prevCounter = 0;
            for (int i = 0; i < currentDNA.length; i++) {

                if (currentDNA[i] == 1) {
                    bestDnaIndex = i;
                    counter++;
                }   else {
                    prevBestIndex = bestDnaIndex;
                    prevCounter = counter;
                    bestDnaIndex = -1;
                    counter = 0;
                }
                if (prevCounter >= counter)  {
                    counter = prevCounter;
                    bestDnaIndex = prevBestIndex;
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

