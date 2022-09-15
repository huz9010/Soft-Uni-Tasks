import java.util.Scanner;

public class SmartLilly {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washerPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());
        int toysCount = 0;
        int moneyForBirthday = 10;
        int money = 0;

        for (int i = 0; i < age; i++) {
            if (i % 2 == 0){
                toysCount++;
            }   else {
                money += (moneyForBirthday -1);
                moneyForBirthday += 10;
            }
        }
        double totalMoney = toysCount * toyPrice + money;

        if (totalMoney >= washerPrice){
            System.out.printf("Yes! %.2f", (totalMoney - washerPrice));
        }   else {
            System.out.printf("No! %.2f", (washerPrice - totalMoney));
        }
    }
}
