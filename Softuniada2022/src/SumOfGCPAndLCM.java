import java.util.Scanner;

public class SumOfGCPAndLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        
        int max = Math.max(firstNum, secondNum);
        int min = Math.min(firstNum, secondNum);

        int gcp = gcd(max, min);
        int lcm = (firstNum * secondNum) / gcp;

        System.out.println(lcm + gcp);
    }

    public static int gcd(int m, int n) {
        if (n > m)  {
            return gcd(n, m);
        }
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }
}
