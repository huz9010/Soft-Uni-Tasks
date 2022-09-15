package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0)  {
                evenSum += input[i];
            }   else {
                oddSum += input[i];
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
