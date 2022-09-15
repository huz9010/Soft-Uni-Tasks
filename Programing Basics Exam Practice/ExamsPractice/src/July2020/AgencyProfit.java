package July2020;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String companyName = scanner.nextLine();
        int adultTickets = Integer.parseInt(scanner.nextLine());
        int kidTickets = Integer.parseInt(scanner.nextLine());
        double adultPrice = Double.parseDouble(scanner.nextLine());
        double taxPrice = Double.parseDouble(scanner.nextLine());

        double adultTicketsProfit = adultTickets * adultPrice + taxPrice * adultTickets;
        double kidTicketProfit = kidTickets * (adultPrice * 0.3) + taxPrice * kidTickets;

        double totalProfit = (adultTicketsProfit + kidTicketProfit) * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, totalProfit);
    }
}
