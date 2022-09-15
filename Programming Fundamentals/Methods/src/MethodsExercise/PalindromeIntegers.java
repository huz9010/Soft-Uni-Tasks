package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")){
            System.out.println(isPalindrome(input));
            input = scanner.nextLine();
        }
    }

    public static boolean isPalindrome(String input){
        int[] num = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        boolean isPalindrome = true;
        for (int i = num.length - 1; i >= num.length / 2; i--) {
            int currentDigit = num[i];
            num[i] = num[num.length - 1 - i];
            num[num.length - 1 - i] = currentDigit;
        }
        for (int i = 0; i < num.length; i++) {
            if (!(num[i] == num2[i])) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
