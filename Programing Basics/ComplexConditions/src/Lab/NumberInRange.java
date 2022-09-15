package Lab;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        boolean inRange = (num >= - 100 && num <= 100 && num !=0);

        if (inRange){
            System.out.println("Yes");
        }   else
            System.out.println("No");
    }
}
