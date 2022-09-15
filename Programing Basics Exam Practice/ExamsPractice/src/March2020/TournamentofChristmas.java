package March2020;

import java.util.Scanner;

public class TournamentofChristmas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalMoney = 0;
        int wins = 0;
        int loses = 0;

        for (int i = 1; i <= days; i++) {

            int winsPerDay = 0;
            int losesPerDay = 0;
            double moneyPerDay = 0;

            String sport = scanner.nextLine();

            while (!sport.equals("Finish")){
                String result = scanner.nextLine();

                if (result.equals("win"))   {
                    moneyPerDay = moneyPerDay + 20;
                    winsPerDay++;
                }   else {
                    losesPerDay++;
                }

                sport = scanner.nextLine();
            }
            if (winsPerDay > losesPerDay)   {
                totalMoney = totalMoney + moneyPerDay * 1.1;
                wins++;
            }   else {
                totalMoney = totalMoney + moneyPerDay;
                loses++;
            }
        }
        if (wins > loses)   {
            totalMoney = totalMoney * 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney);
        }   else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }

    }
}
