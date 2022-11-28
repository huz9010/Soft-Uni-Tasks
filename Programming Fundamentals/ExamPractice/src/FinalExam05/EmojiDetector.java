package FinalExam05;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        long threshold = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                threshold *= Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        }

        Pattern pattern = Pattern.compile("(?<delimiter>:{2}|\\*{2})([A-Z][a-z]{2,})\\k<delimiter>");
        Matcher matcher = pattern.matcher(input);

        int emojiCount = 0;
        List<String> coolEmojis = new ArrayList<>();

        while (matcher.find())  {
            emojiCount++;
            int emojiCoolness = 0;
            for (int i = 2; i < matcher.group().length() - 2; i++) {
                emojiCoolness += matcher.group().charAt(i);
            }

            if (emojiCoolness >= threshold) {
                coolEmojis.add(matcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCount);
        for (String item:coolEmojis) {
            System.out.println(item);
        }
    }
}
