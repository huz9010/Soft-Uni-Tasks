package FinalExamRetake01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> itemList = new ArrayList<>();

        Pattern pattern = Pattern.compile("(?<delimiter>#|\\|)(?<name>[A-Za-z\\s]+)\\k<delimiter>(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\k<delimiter>" +
                "(?<calories>[0-9]+)\\k<delimiter>");
        Matcher matcher = pattern.matcher(input);
        int totalCalories = 0;
        while (matcher.find())  {
            totalCalories += Integer.parseInt(matcher.group("calories"));
            itemList.add(String.format("Item: %s, Best before: %s, Nutrition: %s", matcher.group("name"), matcher.group("date"), matcher.group("calories")));
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);

        for (String item : itemList) {
            System.out.println(item);
        }
    }
}
