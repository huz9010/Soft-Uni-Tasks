package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (num.length > 1) {
            int[] condensed = new int[num.length - 1];
            for (int i = 0; i < condensed.length; i++) {

                condensed[i] = num[i] + num[i + 1];
            }
            num = condensed;
        }
        System.out.println(num[0]);
    }
}
