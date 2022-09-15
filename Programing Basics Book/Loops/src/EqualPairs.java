import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int maxDiff = 0;
        int prevSum = 0;
        int diff = 0;

        for (int i = 1; i <= n; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());

            int sum = num1 + num2;

            if (i == 1){
                prevSum = sum;
            }   else {
                diff = Math.abs(prevSum - sum);
                prevSum = sum;
            }
                if (diff > maxDiff){
                    maxDiff = diff;

            }
        }
        if (maxDiff == 0) {
            System.out.printf("Yes, value=%d", prevSum);
        }   else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}
