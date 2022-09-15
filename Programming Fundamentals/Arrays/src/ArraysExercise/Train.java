package ArraysExercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());

        int[] peopleArr = new int[wagons];
        int sum = 0;

        for (int i = 0; i < wagons; i++) {
            peopleArr[i] = Integer.parseInt(scanner.nextLine());
            sum += peopleArr[i];
            System.out.print(peopleArr[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
