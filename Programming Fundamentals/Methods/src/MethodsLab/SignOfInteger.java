package MethodsLab;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        numSign(num);
    }

    public static void numSign (int num) {
        if (num == 0)   {
            System.out.println("The number 0 is zero.");
        } else if (num < 0) {
            System.out.printf("The number %d is negative.", num);
        }   else {
            System.out.printf("The number %d is positive.", num);
        }
    }
}
