import java.util.Scanner;

public class TimePlus15 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int totalm = m + 15;

        if (totalm >= 60) {
            h = h + 1;
            totalm = totalm - 60;
        }
        if (h > 23){
            h = 0;
        }
        if (totalm < 10){
            System.out.printf("%d:0%d", h, totalm);
        } else
            System.out.printf("%d:%d", h, totalm);

    }
}
