package NestedLoopsExercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());


        for (int i = 1111; i <= 9999 ; i++) {

            int counter = 0;
            int currentNum = i;

            for (int j = 4; j >= 1 ; j--) {
                int digit = currentNum % 10;

                if (digit == 0) {
                    continue;
                }
                else if (num % digit == 0)   {
                    counter++;
                }
                currentNum = currentNum / 10;
            }
            if (counter == 4)   {
                System.out.printf("%d ",i);
            }
        }
    }
}
