package ExamJune2022;

import java.util.Scanner;

public class ExcursionCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        double totalPrice = 0;


        if (people <= 5)    {
            if (season.equals("spring"))    {
                totalPrice = people * 50;
            } else if (season.equals("summer")) {
                totalPrice = people * 48.50 * 0.85;
            } else if (season.equals("autumn")) {
                totalPrice = people * 60;
            } else if (season.equals("winter")) {
                totalPrice = people * 86 * 1.08;
            }
        } else {
            if (season.equals("spring"))    {
                totalPrice = people * 48;
            } else if (season.equals("summer")) {
                totalPrice = people * 45 * 0.85;
            } else if (season.equals("autumn")) {
                totalPrice = people * 49.50;
            } else if (season.equals("winter")) {
                totalPrice = people * 85 * 1.08;
            }
        }
        System.out.printf("%.2f leva.", totalPrice);
    }
}
