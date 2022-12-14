package NestedLoopsExercise;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int currentNum = 1;
        boolean isBigger = false;

        for (int rows = 1; rows <= n ; rows++) {
            for (int cols = 1; cols <= rows ; cols++) {
                if (currentNum > n) {
                    isBigger = true;
                    break;
                }
                System.out.printf(currentNum + " ");
                currentNum++;
            }
                if (isBigger)   {
                    break;
                }
            System.out.println();
        }
    }
}
