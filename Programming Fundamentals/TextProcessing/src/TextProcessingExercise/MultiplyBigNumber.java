package TextProcessingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int num = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        int firstDigit = 0;

        if (num == 0 || bigNum.equals("0") || bigNum.isEmpty()) {
            System.out.println(0);
        } else {
            for (int i = bigNum.length() - 1; i >= 0; i--) {
                int currentNum = Integer.parseInt(String.valueOf(bigNum.charAt(i)));
                int product = num * currentNum + firstDigit;
                if (product < 10) {
                    result.append(product);
                    firstDigit = 0;
                } else {
                    int lastDigit = product % 10;
                    firstDigit = product / 10;
                    result.append(lastDigit);
                }
            }
            if (firstDigit != 0) {
                result.append(firstDigit);
            }
            System.out.println(result.reverse());
        }
    }
}
