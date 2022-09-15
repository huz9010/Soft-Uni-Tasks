package March2019;

import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String stage = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int ticketCount = Integer.parseInt(scanner.nextLine());
        String photo = scanner.nextLine();
        double bill = 0;

        switch (stage)    {
            case "Quarter final":
                if (ticketType.equals("Standard")){
                    bill = ticketCount * 55.5;
                } else if (ticketType.equals("Premium")) {
                    bill = ticketCount * 105.2;
                }   else {
                    bill = ticketCount * 118.9;
                }
                break;

            case "Semi final":
                if (ticketType.equals("Standard")){
                    bill = ticketCount * 75.88;
                } else if (ticketType.equals("Premium")) {
                    bill = ticketCount * 125.22;
                }   else {
                    bill = ticketCount * 300.4;
                }
                break;

            case "Final":
                if (ticketType.equals("Standard")){
                    bill = ticketCount * 110.1;
                } else if (ticketType.equals("Premium")) {
                    bill = ticketCount * 160.66;
                }   else {
                    bill = ticketCount * 400;
                }
                break;
        }
        switch (photo)  {
            case "Y":
                if (bill > 4000)    {
                    bill = bill * 0.75;
                } else if (bill > 2500) {
                    bill = bill * 0.9 + ticketCount * 40;
                }   else {
                    bill = bill + ticketCount * 40;
                }
                break;

            case "N":
                if (bill > 4000)    {
                    bill = bill * 0.75;
                } else if (bill > 2500) {
                    bill = bill * 0.9;
                }
        }
        System.out.printf("%.2f", bill);
    }
}
