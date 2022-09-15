package MethodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(multiplyEvenOdd(Math.abs(num)));

    }

    public static Integer getEvenSum(int num) {
        int evenSum = 0;
        while (num > 0) {
            if ((num % 10) % 2 == 0) {
                evenSum += num % 10;
            }
            num = num / 10;
        }
        return evenSum;
    }

    public static Integer getOddSum(int num) {
        int oddSum = 0;
        while (num > 0) {
            if (!((num % 10) % 2 == 0)) {
                oddSum += num % 10;
            }
            num = num / 10;
        }
        return oddSum;
    }

    public static Integer multiplyEvenOdd(int num)  {
        return getEvenSum(num) * getOddSum(num);
    }
}
