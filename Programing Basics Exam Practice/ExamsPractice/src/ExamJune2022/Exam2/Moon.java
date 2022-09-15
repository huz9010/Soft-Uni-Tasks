package ExamJune2022.Exam2;

import java.util.Scanner;

public class Moon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double speed = Double.parseDouble(scanner.nextLine());
        double fuelFor100 = Double.parseDouble(scanner.nextLine());

        double totalTime = Math.ceil(384400 * 2 / speed) + 3;
        double totalFuel = fuelFor100 * 384400 * 2 / 100;

        System.out.printf("%.0f%n%.0f", totalTime, totalFuel);
    }
}
