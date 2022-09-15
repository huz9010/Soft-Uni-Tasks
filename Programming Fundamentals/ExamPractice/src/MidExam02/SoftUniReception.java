package MidExam02;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int emp1Efficiency = Integer.parseInt(scanner.nextLine());
        int emp2Efficiency = Integer.parseInt(scanner.nextLine());
        int emp3Efficiency = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int teamEfficiency = emp1Efficiency + emp2Efficiency + emp3Efficiency;
        int hoursNeeded = 0;

        while (studentsCount > 0){
            studentsCount = studentsCount - teamEfficiency;
            hoursNeeded++;
            if (hoursNeeded % 4 == 0){
                hoursNeeded++;
            }
        }
        System.out.printf("Time needed: %dh.", hoursNeeded);
    }
}
