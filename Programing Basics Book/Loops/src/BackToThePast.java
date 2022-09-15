import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());
        int age = 18;
        double evenMoney = 0;
        double oddMoney = 0;

        for (int i = 1800; i <= year; i++) {
            if (i % 2 == 0){
                evenMoney += 12000;
            }   else {
                oddMoney += (12000 + 50 * age);
            }
            age++;
        }
        double allMoney = evenMoney + oddMoney;

        if (allMoney <= money){
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", (money - allMoney));
        }   else {
            System.out.printf("He will need %.2f dollars to survive.", (allMoney - money));
        }
    }
}
