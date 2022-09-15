package MidExam05;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        int[] attendances = new int[studentCount];
        double[] bonuses = new double[studentCount];

        for (int i = 0; i < studentCount; i++) {
            attendances[i] = Integer.parseInt(scanner.nextLine());
            bonuses[i] = attendances[i] * 1.0 / lecturesCount * (5 + bonus);
        }
        double maxBonus = 0;
        int studentAttendances = 0;

        for (int i = 0; i < bonuses.length; i++) {
            if (bonuses[i] > maxBonus){
                maxBonus = bonuses[i];
                studentAttendances = attendances[i];
            }
        }
        System.out.printf("Max Bonus: %.0f.%n" +
                "The student has attended %d lectures.", Math.ceil(maxBonus), studentAttendances);
    }
}
