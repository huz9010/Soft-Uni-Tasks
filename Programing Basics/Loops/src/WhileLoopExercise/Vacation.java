package WhileLoopExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        int spendingDays = 0;
        int totalDays = 0;

        while (availableMoney < neededMoney && spendingDays < 5)    {

            String action = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());

            if (action.equals("save")) {
                availableMoney = availableMoney + money;
                totalDays++;
                spendingDays = 0;
            }

            else if (action.equals("spend")) {
                availableMoney = availableMoney - money;
                totalDays++;
                spendingDays++;

                if (availableMoney <= 0) {
                    availableMoney = 0;

                }
            }
        }
        if (spendingDays == 5)  {
            System.out.printf("You can't save the money.%n%d", totalDays);
        }   else {
            System.out.printf("You saved the money for %d days.", totalDays);
        }
    }
}
