package BasicSyntaxConditionalStatementsandLoopsLab;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());
        int result = 0;

        if (multiplier <= 10) {
            for (int i = multiplier; i <= 10; i++) {
                result = num * i;
                System.out.printf("%d X %d = %d%n", num, i, result);
            }
        }   else {
            result = num * multiplier;
            System.out.printf("%d X %d = %d%n", num, multiplier, result);
        }
    }
}
