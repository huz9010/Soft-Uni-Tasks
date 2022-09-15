package DrawingOnTheConsole;

import java.util.Scanner;


public class RectangleNNStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String symbol = "*";

        for (int i = 0; i < n; i++) {
            System.out.println(generateFrom(n, symbol));
        }
    }
    public static String generateFrom (int numberOfStars, String symbol) {
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < numberOfStars; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }
}
