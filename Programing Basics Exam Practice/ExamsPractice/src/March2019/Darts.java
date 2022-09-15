package March2019;

import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String player = scanner.nextLine();
        String area = scanner.nextLine();
        int totalPoints = 301;
        int successful = 0;
        int unsuccessful = 0;

        while (!area.equals("Retire")) {
            int points = Integer.parseInt(scanner.nextLine());

            switch (area) {

                case "Double":
                    points = points * 2;
                    break;

                case "Triple":
                    points = points * 3;
                    break;
            }
            if (points > totalPoints) {
                unsuccessful++;
            } else {
                totalPoints = totalPoints - points;
               successful++;

               if (totalPoints == 0) {
                   break;
               }
            }
            area = scanner.nextLine();
        }
        if (totalPoints == 0)   {
            System.out.printf("%s won the leg with %d shots.", player, successful);
        }   else    {
            System.out.printf("%s retired after %d unsuccessful shots.", player, unsuccessful);
        }
    }
}
