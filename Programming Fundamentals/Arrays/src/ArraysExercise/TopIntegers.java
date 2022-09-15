package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            boolean isTop = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] <= array[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop)  {
                System.out.print(array[i] + " ");
            }
        }
    }
}
