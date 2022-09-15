package DataTypesAndVariablesLab;

import java.math.BigDecimal;
import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigDecimal pounds = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        BigDecimal dollars = pounds.multiply(BigDecimal.valueOf(1.36));

        System.out.printf("%.3f", dollars);
    }
}
