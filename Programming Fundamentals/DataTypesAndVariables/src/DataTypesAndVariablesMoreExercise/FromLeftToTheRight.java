package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= lines; i++) {
            String[] input = scanner.nextLine().split(" ");
            long leftNum = Long.parseLong(input[0]);
            long rightNum = Long.parseLong(input[1]);
            int sum = 0;

            if (leftNum > rightNum) {
                while (leftNum != 0) {
                    sum += Math.abs(leftNum % 10);
                    leftNum = leftNum / 10;
                }
            }   else {
                while (rightNum != 0) {
                    sum += Math.abs(rightNum % 10);
                    rightNum = rightNum / 10;
                }
            }
            System.out.println(sum);
        }
    }
}
