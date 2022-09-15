package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int counter = 1;
        int maxCount = 1;
        int num = 0;

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1])   {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > maxCount) {
                maxCount = counter;
                num = array[i];
            }
        }
        int[] sequence = new int[maxCount];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = num;
        }
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
        }
    }
}
