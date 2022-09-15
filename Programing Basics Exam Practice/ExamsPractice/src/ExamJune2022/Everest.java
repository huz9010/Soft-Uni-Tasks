package ExamJune2022;

import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int days = 1;
        int startingPoint = 5364;
        int target = 8848;
        boolean failed = false;

        while (startingPoint < target)    {
            String sleep = scanner.nextLine();
            if (sleep.equals("Yes"))    {
                days++;
            } else if (sleep.equals("END")) {
                break;
            }

           if (days > 5) {

                break;
            }
            int metersForDay = Integer.parseInt(scanner.nextLine());
            startingPoint = startingPoint + metersForDay;


        }
        if (startingPoint < target) {
            System.out.printf("Failed!%n%d", startingPoint);
        }   else {
            System.out.printf("Goal reached for %d days!", days);
        }
    }
}
