package MidExamRetake01;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {
            while ((lift[i] < 4 && peopleWaiting > 0)) {
                lift[i]++;
                peopleWaiting--;
                }
            }
        if (peopleWaiting == 0 && lift[lift.length - 1] < 4) {
            System.out.println("The lift has empty spots!");
        } else if (peopleWaiting != 0 && lift[lift.length - 1] == 4) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
            }
            for (int wagon : lift) {
                System.out.print(wagon + " ");
        }
    }
}
