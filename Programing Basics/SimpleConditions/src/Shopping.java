import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int vgaCount = Integer.parseInt(scanner.nextLine());
        int cpuCount = Integer.parseInt(scanner.nextLine());
        int ramCount = Integer.parseInt(scanner.nextLine());

        double vgaPrice = vgaCount * 250.0;
        double cpuPrice = cpuCount * (vgaPrice * 0.35);
        double ramPrice = ramCount * (vgaPrice* 0.1);

        double totalPrice = vgaPrice + cpuPrice + ramPrice;

        if (vgaCount > cpuCount) {
            totalPrice = totalPrice - totalPrice * 0.15;
        }
        if (totalPrice <= budget){
            System.out.printf("You have %.2f leva left!", budget - totalPrice);
        }   else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - budget);
        }
    }
}
