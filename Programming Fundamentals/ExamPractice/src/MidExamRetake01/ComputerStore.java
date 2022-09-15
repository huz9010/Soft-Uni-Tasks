package MidExamRetake01;

import java.math.BigDecimal;
import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        BigDecimal totalPrice = new BigDecimal(0);
        boolean isSpecial = false;

        while (!input.equals("special") && !input.equals("regular")){
            BigDecimal currentPrice = new BigDecimal(Double.parseDouble(input));
            if (currentPrice.compareTo(BigDecimal.ZERO) < 0){
                System.out.println("Invalid price!");
            }   else {
                totalPrice = totalPrice.add(currentPrice);
            }
            input = scanner.nextLine();
            if (input.equals("special")){
                isSpecial = true;
            }
        }
        BigDecimal taxes = totalPrice.multiply(BigDecimal.valueOf(0.2));
        BigDecimal totalWithTaxes = totalPrice.add(taxes);

        if (totalPrice.compareTo(BigDecimal.ZERO) == 0){
            System.out.println("Invalid order!");
        } else if (isSpecial) {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n", totalPrice, taxes, totalWithTaxes.multiply(BigDecimal.valueOf(0.9)));
        } else {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n", totalPrice, taxes, totalWithTaxes);
        }
    }
}
