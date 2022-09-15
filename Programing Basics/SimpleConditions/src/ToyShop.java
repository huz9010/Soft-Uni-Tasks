import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double holidayPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double puzzlesPrice = puzzles * 2.6;
        double dollsPrice = dolls * 3.0;
        double teddyBearsPrice = teddyBears * 4.1;
        double minionsPrice = minions * 8.2;
        double trucksPrice = trucks * 2.0;

        int toysCount = puzzles + dolls + teddyBears + minions + trucks;
        double totalPrice = puzzlesPrice + dollsPrice + teddyBearsPrice + minionsPrice + trucksPrice;

        double income = 0;

        if (toysCount >= 50){
            income = (totalPrice - totalPrice * 0.25) - (totalPrice - totalPrice * 0.25) * 0.1;
        }   else {
            income = totalPrice - totalPrice * 0.1;
        }
        if (income >= holidayPrice){
            System.out.printf("Yes! %.2f lv left.", income - holidayPrice);
        }   else {
            System.out.printf("Not enough money! %.2f lv needed.", holidayPrice - income);
        }
    }
}
