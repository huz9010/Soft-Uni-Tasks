package MidExam04;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighbourhood = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();
        int position = 0;

        String input = scanner.nextLine();

        while (!input.equals("Love!")){
            String[] command = input.split(" ");
            int jump = Integer.parseInt(command[1]);
            position += jump;
            if (position >= neighbourhood.length){
                position = 0;
            }
            if (neighbourhood[position] == 0){
                System.out.printf("Place %d already had Valentine's day.%n", position);
            }   else {
                neighbourhood[position] -= 2;
                if (neighbourhood[position] == 0){
                    System.out.printf("Place %d has Valentine's day.%n", position);
                }
            }
            input = scanner.nextLine();
        }
        int failedCount = 0;
        for (int j : neighbourhood) {
            if (j > 0) {
                failedCount++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", position);
        if (failedCount == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", failedCount);
        }
    }
}
