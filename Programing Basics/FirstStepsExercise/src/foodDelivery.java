import java.util.Scanner;

public class foodDelivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int chickenMenus = Integer.parseInt(scanner.nextLine());
        int fishMenus = Integer.parseInt(scanner.nextLine());
        int  vegyMenus = Integer.parseInt(scanner.nextLine());

        double chickenPrice = chickenMenus * 10.35;
        double fishPrice = fishMenus * 12.40;
        double vegyPrice = vegyMenus * 8.15;
        double desertPrice = (chickenPrice + fishPrice + vegyPrice)*0.2;
        double delivery = 2.5;

        double sum = chickenPrice + fishPrice + vegyPrice + desertPrice + delivery;

        System.out.println(sum);

        }

    }

