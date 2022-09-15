import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String daytime = scanner.nextLine();
        double price = 0;
        double taxiRate = 0;
        if (daytime.equals("day")) {
            taxiRate = 0.79;
        } else if  (daytime.equals("night")) {
            taxiRate = 0.90;
        }
        if (n < 20){
            price = 0.7 + n * taxiRate;
        } else if (n < 100) {
            price = n * 0.09;
        } else {
            price = n * 0.06;
        }
        System.out.println(price);
    }
}