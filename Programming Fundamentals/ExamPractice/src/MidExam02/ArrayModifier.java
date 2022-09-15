package MidExam02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);

                    int temp = array[index1];
                    array[index1] = array[index2];
                    array[index2] = temp;
                    break;

                case "multiply":
                    index1 = Integer.parseInt(command[1]);
                    index2 = Integer.parseInt(command[2]);

                    array[index1] = array[index1] * array[index2];
                    break;

                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i] -= 1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
    }
}
