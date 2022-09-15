import java.util.Scanner;

public class Division {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        int p1Count = 0;
        int p2Count = 0;
        int p3Count = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            if (num % 2 == 0){
                p1Count++;
            }
            if (num % 3 == 0){
                p2Count++;
            }
            if (num % 4 == 0){
                p3Count++;
            }
        }
        p1 = p1Count * 100.0 / n;
        p2 = p2Count * 100.0 / n;
        p3 = p3Count * 100.0 / n;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3);
    }
}
