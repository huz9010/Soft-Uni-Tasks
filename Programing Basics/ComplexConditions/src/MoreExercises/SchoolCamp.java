package MoreExercises;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine().toLowerCase();
        String groupType = scanner.nextLine().toLowerCase();
        int students = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());

        String sport = "";
        double price = 0;
        double totalPrice = 0;

        switch (season) {
            case "winter":
                switch (groupType){
                    case "girls":
                        sport = "Gymnastics";
                        price = students * nights * 9.60;
                        break;
                    case "boys":
                        sport = "Judo";
                        price = students * nights * 9.60;
                        break;
                    case "mixed":
                        sport = "Ski";
                        price = students * nights * 10;
                        break;
                }
                break;
            case "spring":
                switch (groupType){
                    case "girls":
                        sport = "Athletics";
                        price = students * nights * 7.20;
                        break;
                    case "boys":
                        sport = "Tennis";
                        price = students * nights * 7.20;
                        break;
                    case "mixed":
                        sport = "Cycling";
                        price = students * nights * 9.5;
                        break;
                }
                break;
            case "summer":
                switch (groupType){
                    case "girls":
                        sport = "Volleyball";
                        price = students * nights * 15.0;
                        break;
                    case "boys":
                        sport = "Football";
                        price = students * nights * 15.0;
                        break;
                    case "mixed":
                        sport = "Swimming";
                        price = students * nights * 20.0;
                        break;
                }
                break;
        }
        if (students >= 50) {
            totalPrice = price - price * 0.5;
        } else if (students >= 20) {
            totalPrice = price - price * 0.15;
        } else if (students >= 10) {
            totalPrice = price - price * 0.05;
        }   else{
            totalPrice = price;
        }
        System.out.printf("%s %.2f lv.", sport ,totalPrice);
    }
}
