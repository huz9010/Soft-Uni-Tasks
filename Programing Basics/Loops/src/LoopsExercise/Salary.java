package LoopsExercise;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= tabs ; i++) {
            String website = scanner.nextLine().toLowerCase();

            switch (website){
                case "facebook":
                    salary -= 150;
                    break;
                case "instagram":
                    salary -= 100;
                    break;
                case "reddit":
                    salary -= 50;
            }
            if (salary <= 0){
                break;
            }
        }
        if (salary <= 0){
            System.out.printf("You have lost your salary.");
        }   else {
            System.out.println(salary);
        }
    }
}
