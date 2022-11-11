package TextProcessingLab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banList = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < banList.length; i++) {
            int count = banList[i].length();
            String banWord = banList[i];
            if (text.contains(banWord))  {
                text = text.replace(banWord, ban(count));
            }
        }
        System.out.println(text);
    }

    public static String ban(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
           result.append("*");
        }
        return result.toString();
    }
}
