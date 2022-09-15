package Lab;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine().toLowerCase();

        switch (day){
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
            case "saturday":
                if (hour >= 10 && hour <= 18){
                    System.out.println("open");
                }   else
                    System.out.println("closed");
                break;
            case "sunday":
                System.out.println("closed");
        }
    }
}
