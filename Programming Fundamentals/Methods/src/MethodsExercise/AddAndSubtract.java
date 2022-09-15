package MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int sum = sum(num1, num2);
        int result = subtract(sum, num3);

        System.out.println(result);
    }

    public static Integer sum(int a, int b){
        return a + b;
    }

    public static Integer subtract(int a, int b){
        return a - b;
    }
}
