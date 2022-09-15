package MethodsExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        printSmallestNum(num1, num2, num3);
    }

    public static void printSmallestNum(int num1, int num2, int num3){
        int smallest = Integer.MAX_VALUE;

        if (num1 < smallest)    {
            smallest = num1;
        }
        if (num2 < smallest)    {
            smallest = num2;
        }
        if (num3 < smallest)    {
            smallest = num3;
        }
        System.out.println(smallest);
    }
}
