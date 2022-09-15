import java.text.DecimalFormat;
import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddSum = 0;
        double oddMin = Double.MAX_VALUE;
        double oddMax = Double.NEGATIVE_INFINITY;
        double evenSum = 0;
        double evenMin = Double.MAX_VALUE;
        double evenMax = Double.NEGATIVE_INFINITY;

        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += num;
                if (num > evenMax) {
                    evenMax = num;
                }
                if (num < evenMin) {
                    evenMin = num;
                }
            } else {
                oddSum += num;
                if (num > oddMax) {
                    oddMax = num;
                }
                if (num < oddMin) {
                    oddMin = num;
                }
            }
        }
        DecimalFormat format = new DecimalFormat("0.#");
        if (n == 0) {
            System.out.printf("OddSum=%s,%n" +
                    "OddMin=No,%n" +
                    "OddMax=No,%n" +
                    "EvenSum=%s,%n" +
                    "EvenMin=No,%n" +
                    "EvenMax=No", format.format(oddSum), format.format(evenSum));
        } else if (n == 1) {
            System.out.printf("OddSum=%s,%n" +
                    "OddMin=%s,%n" +
                    "OddMax=%s,%n" +
                    "EvenSum=%s,%n" +
                    "EvenMin=No,%n" +
                    "EvenMax=No", format.format(oddSum), format.format(oddMin), format.format(oddMax), format.format(evenSum));
        } else {
            System.out.printf("OddSum=%s,%n" +
                    "OddMin=%s,%n" +
                    "OddMax=%s,%n" +
                    "EvenSum=%s,%n" +
                    "EvenMin=%s,%n" +
                    "EvenMax=%s", format.format(oddSum), format.format(oddMin), format.format(oddMax), format.format(evenSum), format.format(evenMin), format.format(evenMax));
        }
    }
    }

