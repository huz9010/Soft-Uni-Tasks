package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dnaLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int[] bestDNA = new int[dnaLength];
        int bestDNAPosition = 1;
        int counter = 0;
        int bestOnesCount = 0;
        int bestIndex = -1;

        while (!input.equals("Clone them!"))    {
            int[] currentDNA = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
            int currentIndex = -1;
            int currentOnesCount = 0;
            int tempCounter = 0;
            counter++;

            for (int i = 0; i < currentDNA.length; i++) {
                if (currentDNA[i] == 1) {
                    tempCounter++;
                }

                if (currentDNA[i] == 0 || i == currentDNA.length - 1) {
                    if (tempCounter > currentOnesCount) {
                        currentOnesCount = tempCounter;
                        currentIndex = i - currentOnesCount;
                        tempCounter = 0;
                    }
                }
            }

                if (isNotBest(bestIndex, currentIndex, bestOnesCount, currentOnesCount))   {
                    bestOnesCount = currentOnesCount;
                    bestIndex = currentIndex;
                    bestDNA = currentDNA;
                    bestDNAPosition = counter;
                }

                if (areBothGood(currentIndex, bestOnesCount, currentOnesCount))     {
                    if (getElementsSum(bestDNA) < getElementsSum(currentDNA))   {
                        bestDNA = currentDNA;
                        bestDNAPosition = counter;
                    }
                }

            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDNAPosition, getElementsSum(bestDNA));
        Arrays.stream(bestDNA).forEach(e -> System.out.print(e + " "));
        }

    private static boolean areBothGood(int currentIndex, int bestOnesCount, int currentOnesCount) {
        return currentOnesCount == bestOnesCount && currentIndex == bestOnesCount;
    }

    private static boolean isNotBest(int bestIndex, int currentIndex, int bestOnesCount, int currentOnesCount) {
        return (currentOnesCount > bestOnesCount) || (currentOnesCount == bestOnesCount && currentIndex < bestIndex);
    }

    private static int getElementsSum(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}

