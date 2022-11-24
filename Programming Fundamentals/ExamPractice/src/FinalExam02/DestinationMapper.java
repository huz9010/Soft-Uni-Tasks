package FinalExam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<delimiter>=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\k<delimiter>");
        Matcher matcher = pattern.matcher(input);
        int travelPoints = 0;
        List<String> destinationList = new ArrayList<>();

        while (matcher.find())  {
            destinationList.add(matcher.group("destination"));
            travelPoints += matcher.group("destination").length();
        }
        if (destinationList.isEmpty())  {
            System.out.println("Destinations:");
        }   else {
            System.out.printf("Destinations: %s%n", String.join(", ", destinationList));
        }
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
