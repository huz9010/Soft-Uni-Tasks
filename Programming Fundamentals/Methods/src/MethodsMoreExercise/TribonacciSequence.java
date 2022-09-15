package MethodsMoreExercise;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        printTribonacci(num);
    }

    public static void printTribonacci(int num){
        int[] tribonacci = new int[num];
        for (int i = 0; i < num; i++) {
            if (i <= 1){
                tribonacci[i] = 1;
            } else if (i == 2) {
                tribonacci[i] = 2;
            } else {
                tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
            }
        }
        for (int element : tribonacci) {
            System.out.print(element + " ");
        }
    }
}
