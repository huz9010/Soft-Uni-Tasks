package DrawingOnTheConsole;

import java.util.Scanner;

public class SqareFrame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.print("+");
        for (int i = 0; i < n - 2; i++) {
            System.out.print(" -");
        }
        System.out.println(" +");

        for (int rows = 0; rows < n - 2; rows++) {
            System.out.print("|");
            for (int i = 0; i < n - 2; i++) {
                System.out.print(" -");
            }
            System.out.println(" |");
        }
        System.out.print("+");
        for (int i = 0; i < n - 2; i++) {
            System.out.print(" -");
        }
        System.out.println(" +");
    }
}
