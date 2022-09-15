package June2019;

import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String packet = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        double bill = 0;

        switch (title)  {
            case "John Wick":
        switch (packet) {
            case "Drink":
                bill = tickets * 12;
                break;
            case "Popcorn":
                bill = tickets * 15;
                break;
            case "Menu":
                bill = tickets * 19;
                break;
        }
        break;
            case "Star Wars":
                switch (packet) {
                    case "Drink":
                        if (tickets >= 4)   {
                            bill = tickets * 18 * 0.7;
                        }   else {
                            bill = tickets * 18;
                        }
                        break;
                    case "Popcorn":
                        if (tickets >= 4)   {
                            bill = tickets * 25 * 0.7;
                        }   else {
                            bill = tickets * 25;
                        }
                        break;
                    case "Menu":
                        if (tickets >= 4)   {
                            bill = tickets * 30 * 0.7;
                        }   else {
                            bill = tickets * 30;
                        }
                        break;
                }
                break;
            case "Jumanji":
                switch (packet) {
                    case "Drink":
                        if (tickets == 2)   {
                            bill = tickets * 9 * 0.85;
                        }   else {
                            bill = tickets * 9;
                        }
                        break;
                    case "Popcorn":
                        if (tickets == 2)   {
                            bill = tickets * 11 * 0.85;
                        }   else {
                            bill = tickets * 11;
                        }
                        break;
                    case "Menu":
                        if (tickets == 2)   {
                            bill = tickets * 14 * 0.85;
                        }   else {
                            bill = tickets * 14;
                        }
                        break;
                }
                break;
        }
        System.out.printf("Your bill is %.2f leva.", bill);
    }
}
