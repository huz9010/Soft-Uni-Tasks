package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");


        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array1[j].equals(array2[i])) {
                    System.out.print(array2[i] + " ");
                }
            }
        }
    }
}
