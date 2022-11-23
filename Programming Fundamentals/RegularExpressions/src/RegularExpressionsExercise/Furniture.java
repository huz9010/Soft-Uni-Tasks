package RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double total = 0;
        System.out.println("Bought furniture:");

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(">>(?<product>\\w+)<<(?<price>\\d+\\.?\\d+?)!(?<quantity>\\d+)");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find())  {
                String product = matcher.group("product");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                System.out.println(product);
                total += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f", total);
    }
}
