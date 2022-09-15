package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        boolean yes = false;

        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if (i > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    leftSum += array[j];
                }
            }
            if (i < array.length - 1)   {
                for (int j = i + 1; j < array.length; j++) {
                    rightSum += array[j];
                }
            }
            if (leftSum == rightSum) {
                index = i;
                yes = true;
            }
        }
        if (yes) {
            System.out.println(index);
        }   else {
            System.out.println("no");
        }
    }
}
