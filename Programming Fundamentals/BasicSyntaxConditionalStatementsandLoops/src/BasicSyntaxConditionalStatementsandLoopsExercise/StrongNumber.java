package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int num = Integer.parseInt(scanner.nextLine());
        int startNum = num;
        int sum = 0;

       while (startNum > 0)  {
           int fact = 1;
           int digit = startNum % 10;
           for (int i = 1; i <= digit; i++) {
               fact = fact * i;
           }
           sum += fact;
           startNum = startNum / 10;
       }
       if (sum == num)  {
           System.out.println("yes");
       }    else {
           System.out.println("no");
       }
    }
}
