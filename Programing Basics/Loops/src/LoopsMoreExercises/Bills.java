package LoopsMoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());
        double electricity = 0;
        double water = 0;
        double internet = 0;

        for (int i = 1; i <= months ; i++) {
            double elPerMonth = Double.parseDouble(scanner.nextLine());

            electricity += elPerMonth;
            water += 20;
            internet += 15;

        }
        double others = (electricity + water + internet) * 1.2;
        double average = (electricity + water + internet + others) / months;

        System.out.printf("Electricity: %.2f lv%n" +
                "Water: %.2f lv%n" +
                "Internet: %.2f lv%n" +
                "Other: %.2f lv%n" +
                "Average: %.2f lv", electricity, water, internet, others, average);
    }
}
