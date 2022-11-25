package FinalExam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int barcodeCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= barcodeCount; i++) {
            String currentBarcode = scanner.nextLine();
            StringBuilder digits = new StringBuilder();
            Pattern pattern = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");
            Matcher matcher = pattern.matcher(currentBarcode);

            if (matcher.find()) {
                for (int j = 0; j < currentBarcode.length(); j++) {
                    if (currentBarcode.charAt(j) >= 48 && currentBarcode.charAt(j) <= 57)   {
                        digits.append(currentBarcode.charAt(j));
                    }
                }
                if (digits.length() == 0)   {
                    System.out.println("Product group: 00");
                }   else {
                    System.out.printf("Product group: %s%n", digits);
                }
            }   else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
