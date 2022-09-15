package DrawingOnTheConsole;

import java.util.Scanner;

public class SquareOfStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int numberOfStars = Integer.parseInt(scanner.nextLine());

        for (int outer = 0; outer < numberOfStars; outer++) {
            for (int inner = 0; inner < numberOfStars; inner++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
