package RegularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,\\s*");

        for (int i = 0; i < tickets.length; i++) {
            Pattern validPattern = Pattern.compile(".{20}");
            Matcher validMatcher = validPattern.matcher(tickets[i]);

            if (validMatcher.find())    {

            }   else {
                System.out.println("invalid ticket");
            }
        }
    }
}
