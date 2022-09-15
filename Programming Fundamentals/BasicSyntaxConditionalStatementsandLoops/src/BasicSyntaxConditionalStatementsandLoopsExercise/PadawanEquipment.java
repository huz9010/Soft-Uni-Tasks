package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int sixthBelt = students / 6;

        double lightsabers = lightsaberPrice * Math.ceil(students * 1.1);
        double robes = robePrice * students;
        double belts = beltPrice * (students - sixthBelt);

        double total = lightsabers + robes + belts;

        if (total > budget) {
            System.out.printf("George Lucas will need %.2flv more.", total - budget);
        }   else {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        }
    }
}
