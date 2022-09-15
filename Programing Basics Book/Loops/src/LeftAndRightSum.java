import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 1; i <= n ; i++) {
            leftSum = leftSum + Integer.parseInt(scanner.nextLine());
        }
        for (int i = n + 1; i <= 2 * n ; i++) {
            rightSum = rightSum + Integer.parseInt(scanner.nextLine());
        }
        if (leftSum == rightSum){
            System.out.printf("Yes, sum = %d", rightSum);
        } else {
            System.out.printf("No, diff = %d", Math.abs(rightSum - leftSum));
        }
    }
}
