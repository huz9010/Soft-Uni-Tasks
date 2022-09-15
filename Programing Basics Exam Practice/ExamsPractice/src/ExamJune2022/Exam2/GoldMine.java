package ExamJune2022.Exam2;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int locations = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= locations; i++) {
            double expectedGold = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            double totalGold = 0;

            for (int j = 1; j <= days; j++) {
                double gold = Double.parseDouble(scanner.nextLine());
                totalGold = totalGold + gold;
            }
            if (totalGold / days >= expectedGold)  {
                System.out.printf("Good job! Average gold per day: %.2f.%n", (totalGold / days));
            }   else {
                System.out.printf("You need %.2f gold.%n", (expectedGold - totalGold / days));
            }
        }
    }
}
