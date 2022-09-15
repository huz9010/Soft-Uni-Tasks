package NestedLoopsExercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= end ; i++) {

            int currentNum = i;

            int evenSum = 0;
            int oddSum = 0;

            for (int j = 6; j >= 1 ; j--) {
                int digit = currentNum % 10;

                if (j % 2 ==0)  {
                    evenSum = evenSum + digit;
                }   else {
                    oddSum = oddSum + digit;
                }
                currentNum = currentNum / 10;
            }
            if (oddSum == evenSum)  {
                System.out.printf(i + " ");
            }
        }
    }
}
