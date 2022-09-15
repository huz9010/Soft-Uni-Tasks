import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal budget = new BigDecimal(scanner.nextLine());
        String season  = scanner.nextLine().toLowerCase();

        BigDecimal summerBg = BigDecimal.valueOf(0.3).multiply(budget);
        BigDecimal winterBg = BigDecimal.valueOf(0.7).multiply(budget);

        BigDecimal summerBalkans = BigDecimal.valueOf(0.4).multiply(budget);
        BigDecimal winterBalkans = BigDecimal.valueOf(0.8).multiply(budget);

        BigDecimal eu = BigDecimal.valueOf(0.9).multiply(budget);

        String destination = "";
        String place = "";
        BigDecimal price = BigDecimal.valueOf(0);

        DecimalFormat formatter = new DecimalFormat("0.00");

        if ((budget.compareTo(BigDecimal.valueOf(100.00)) <= 0) && (season.equals("summer"))) {
            destination = "Bulgaria";
            place = "Camp";
            price = summerBg;
        } else if ((budget.compareTo(BigDecimal.valueOf(100.00)) <= 0) && (season.equals("winter"))) {
            destination = "Bulgaria";
            place = "Hotel";
            price = winterBg;
        } else if ((budget.compareTo(BigDecimal.valueOf(1000.00)) <= 0) && (season.equals("summer"))) {
            destination = "Balkans";
            place = "Camp";
            price = summerBalkans;
        } else if ((budget.compareTo(BigDecimal.valueOf(1000.00)) <= 0) && (season.equals("winter"))) {
            destination = "Balkans";
            place = "Hotel";
            price = winterBalkans;
        }   else {
            destination = "Europe";
            place = "Hotel";
            price = eu;
    }
        System.out.printf("Somewhere in %s%n %s - %s", destination, place, formatter.format(price));
    }
}
