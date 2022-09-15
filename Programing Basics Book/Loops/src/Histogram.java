import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        int cntP1 = 0;
        int cntP2 = 0;
        int cntP3 = 0;
        int cntP4 = 0;
        int cntP5 = 0;

        for (int i = 1; i <= n; i++){
            int num = Integer.parseInt(scanner.nextLine());

            if (num < 200){
                cntP1++;
            } else if (num <= 399) {
                cntP2++;
            } else if (num <= 599) {
                cntP3++;
            } else if (num <= 799) {
                cntP4++;
            } else {
                cntP5++;
            }
        }
        p1 = cntP1 * 100.0 / n;
        p2 = cntP2 * 100.0 / n;
        p3 = cntP3 * 100.0 / n;
        p4 = cntP4 * 100.0 / n;
        p5 = cntP5 * 100.0 / n;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n", p1, p2 ,p3, p4, p5);
    }
}
