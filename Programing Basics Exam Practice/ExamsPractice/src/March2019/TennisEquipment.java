package March2019;

import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double racquetPrice = Double.parseDouble(scanner.nextLine());
        int racquetCount = Integer.parseInt(scanner.nextLine());
        int sneakersCount = Integer.parseInt(scanner.nextLine());

        double totalPrice = racquetPrice * racquetCount + sneakersCount * racquetPrice / 6
                + (racquetPrice * racquetCount + sneakersCount * racquetPrice / 6) * 0.2;
        double playerBill = totalPrice / 8;
        double sponsorBill = totalPrice * 7 / 8;

        System.out.printf("Price to be paid by Djokovic %.0f%n" +
                "Price to be paid by sponsors %.0f", Math.floor(playerBill), Math.ceil(sponsorBill));
    }
}
