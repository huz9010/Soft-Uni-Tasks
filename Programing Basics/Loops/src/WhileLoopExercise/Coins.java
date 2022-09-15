package WhileLoopExercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        double changeInCoins = change * 100;
        int coinCount = 0;

        while (changeInCoins > 0)  {

            if (changeInCoins >= 200){
                changeInCoins = changeInCoins - 200;
                coinCount++;
            }
            else if (changeInCoins >= 100) {
                changeInCoins = changeInCoins - 100;
                coinCount++;
            }
            else if (changeInCoins >= 50) {
                changeInCoins = changeInCoins - 50;
                coinCount++;
            }
            else if (changeInCoins >= 20) {
                changeInCoins = changeInCoins - 20;
                coinCount++;
            }
            else if (changeInCoins >= 10) {
                changeInCoins = changeInCoins - 10;
                coinCount++;
            }
            else if (changeInCoins >= 5) {
                changeInCoins = changeInCoins - 5;
                coinCount++;
            }
            else if (changeInCoins >= 2) {
                changeInCoins = changeInCoins - 2;
                coinCount++;
            }
            else if (changeInCoins >= 1) {
                changeInCoins = changeInCoins - 1;
                coinCount++;
            }   else {
                break;
            }
        }
        System.out.println(coinCount);
    }
}
