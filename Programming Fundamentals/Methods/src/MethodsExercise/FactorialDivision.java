package MethodsExercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num1 = Integer.parseInt(scanner.nextLine());
        long num2 = Integer.parseInt(scanner.nextLine());

        long factorial1 = calculateFactorial(num1);
        long factorial2 = calculateFactorial(num2);

        printFactorialDivision(factorial1, factorial2);
    }

    public static long calculateFactorial(long a){
        long result = 1;

            for (long i = a; i >= 1; i--) {
                result = result * i;
            }
        return result;
    }

    public static void printFactorialDivision(long a, long b){
        double result = (double) a / (double) b;
        System.out.printf("%.2f", result);
    }
}
