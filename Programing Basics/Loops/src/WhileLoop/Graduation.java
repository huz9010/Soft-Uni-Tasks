package WhileLoop;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int year = 1;
        double sum = 0;
        int poorGrade = 0;

        while (year <= 12) {

            if (poorGrade == 2){
                break;
            }

            double currentGrade = Double.parseDouble(scanner.nextLine());

            if (currentGrade < 4) {
                poorGrade++;
                continue;
            }
            year++;
            sum = sum + currentGrade;
        }
        if (poorGrade == 2) {
            System.out.printf("%s has been excluded at %d grade", name, year);
        }
        else {
            double avgGrade = sum / (year - 1);
            System.out.printf("%s graduated. Average grade: %.2f", name, avgGrade);
        }
    }
}
