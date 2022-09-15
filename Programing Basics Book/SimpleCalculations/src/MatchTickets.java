import java.beans.PropertyEditorSupport;
import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String cat = scanner.nextLine().toLowerCase();
        int people = Integer.parseInt(scanner.nextLine());

        double money = 0;
        double moneyNeeded = 0;

        if (people > 0 && people <= 4){
            money = budget - budget * 0.75;
        } else if ((people > 4 && people <= 9)) {
            money = budget - budget * 0.6;
        } else if ((people > 9 && people <= 24)) {
            money = budget - budget * 0.5;
        } else if ((people > 24 && people <= 49)) {
            money = budget - budget * 0.4;
        } else {
            money = budget - budget * 0.25;
        }
        switch (cat){
            case "vip":
                moneyNeeded = 499.99 * people;
                break;
            case "normal":
                moneyNeeded = 249.99 * people;
                break;
        }
        double moneyDifference = money - moneyNeeded;

        if (money >= moneyNeeded){
            System.out.printf("Yes! You have %.2f leva left.", Math.abs(moneyDifference));
        }   else {
            System.out.printf("Not enough money! You need %.2f leva." , Math.abs(moneyDifference));
        }
    }
}
