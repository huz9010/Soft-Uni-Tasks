package ExamJune2022.Exam2;

import java.util.Scanner;

public class CatLife {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String breed = scanner.nextLine();
        char sex = scanner.nextLine().charAt(0);
        int life = 0;

        switch (breed)  {
            case "British Shorthair":
                if (sex == 'm') {
                    life = 13 * 2;
                } else if (sex == 'f') {
                    life = 14 * 2;
                }
                System.out.printf("%d cat months", life);
                break;

            case "Siamese":
                if (sex == 'm') {
                    life = 15 * 2;
                } else if (sex == 'f') {
                    life = 16 * 2;
                }
                System.out.printf("%d cat months", life);
                break;

            case "Persian":
                if (sex == 'm') {
                    life = 14 * 2;
                } else if (sex == 'f') {
                    life = 15 * 2;
                }
                System.out.printf("%d cat months", life);
                break;

            case "Ragdoll":
                if (sex == 'm') {
                    life = 16 * 2;
                } else if (sex == 'f') {
                    life = 17 * 2;
                }
                System.out.printf("%d cat months", life);
                break;
            case "American Shorthair":
                if (sex == 'm') {
                    life = 12 * 2;
                } else if (sex == 'f') {
                    life = 13 * 2;
                }
                System.out.printf("%d cat months", life);
                break;

            case "Siberian":
                if (sex == 'm') {
                    life = 11 * 2;
                } else if (sex == 'f') {
                    life = 12 * 2;
                }
                System.out.printf("%d cat months", life);
                break;

            default:
                System.out.printf("%s is invalid cat!", breed);
        }
    }
}
