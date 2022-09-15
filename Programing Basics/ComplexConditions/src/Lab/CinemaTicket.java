package Lab;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine().toLowerCase();

        switch (day){
            case "monday":
            case "tuesday":
            case "friday":
                System.out.println("12");
                break;
            case "wednesday":
            case "thursday":
                System.out.println(14);
                break;
            case "saturday":
            case "sunday":
                System.out.println("16");
        }
    }
}
