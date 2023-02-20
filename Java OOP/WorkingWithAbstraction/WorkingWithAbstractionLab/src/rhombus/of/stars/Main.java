package rhombus.of.stars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(i, n);
        }

        for (int i = n - 1; i >= 1 ; i--) {
            printRow(i, n);
        }
    }

    public static void printRow(int r, int n)  {
        for (int i = 0; i < n - r; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < r; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
