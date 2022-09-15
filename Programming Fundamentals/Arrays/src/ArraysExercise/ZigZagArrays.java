package ArraysExercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] currentArr = new int[2];
            for (int j = 0; j < currentArr.length; j++) {
                currentArr[j] = Integer.parseInt(scanner.next());
            }
            if (i % 2 == 0) {
                array1[i] = currentArr[0];
                array2[i] = currentArr[1];
            } else {
                array2[i] = currentArr[0];
                array1[i] = currentArr[1];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(array2[i] + " ");
        }
    }
}
