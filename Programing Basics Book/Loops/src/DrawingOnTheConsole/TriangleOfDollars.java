package DrawingOnTheConsole;

import java.util.Scanner;

public class TriangleOfDollars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= n; rows++) {
            System.out.print("$ ");
            for (int cols = 1; cols < rows; cols++) {
                System.out.print("$ ");
            }
            System.out.println();
        }
    }
}
