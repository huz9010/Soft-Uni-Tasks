package ArraysMoreExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(Fibonacci(n));
    }
    public static long[] fibArray = new long[51];

    public static long Fibonacci (int n){
        long fibValue = 0;
        if (n == 0){
            return 0;
        }   else if (n == 1){
            return 1;
        } else if (fibArray[n] != 0) {
            return fibArray[n];
        }   else {
            fibValue = Fibonacci(n - 1) + Fibonacci(n - 2);
            fibArray[n] = fibValue;
            return fibValue;
        }
    }
}
