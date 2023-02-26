import java.util.Scanner;

public class RowInPascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long prev = 1;
        System.out.print(prev);

        for(int i = 1; i <= n; i++) {

            long curr = (prev * (n - i + 1)) / i;
            System.out.print(" " + curr);
            prev = curr;
        }
    }
}
