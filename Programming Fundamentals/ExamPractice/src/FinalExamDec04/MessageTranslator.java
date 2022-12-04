package FinalExamDec04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = "";
            String string = ";";
            List<Integer> nums = new ArrayList<>();

            Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<string>[A-Za-z]{8,})]");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                command = matcher.group("command");
                string = matcher.group("string");

                for (int j = 0; j < string.length(); j++) {
                    nums.add((int) string.charAt(j));
                }

                System.out.printf("%s: ", command);
                for (int j = 0; j < nums.size(); j++) {
                    System.out.printf("%d ", nums.get(j));
                }
                System.out.println();
            }   else {
                System.out.println("The message is invalid");
            }
        }
    }
}
