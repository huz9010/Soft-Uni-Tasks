package RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> participantList = new LinkedHashMap<>();
        participants.forEach(name -> participantList.put(name, 0));

        while (!input.equals("end of race")) {
            Pattern namePattern = Pattern.compile("[A-Za-z]");
            Matcher nameMatcher = namePattern.matcher(input);
            Pattern numPattern = Pattern.compile("[0-9]");
            Matcher numMatcher = numPattern.matcher(input);
            StringBuilder currentName = new StringBuilder();

            while (nameMatcher.find()) {
                currentName.append(nameMatcher.group());
            }

            int currentDistance = 0;

            while (numMatcher.find()) {
                currentDistance += Integer.parseInt(numMatcher.group());
            }
            if (participants.contains(currentName.toString())) {
                int racerDistance = participantList.get(currentName.toString()) + currentDistance;
                participantList.put(String.valueOf(currentName), racerDistance);
            }
            input = scanner.nextLine();
        }

        List<String> top3Names = participantList.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).map(entry -> entry.getKey()).collect(Collectors.toList());

        System.out.println("1st place: " + top3Names.get(0));
        System.out.println("2nd place: " + top3Names.get(1));
        System.out.println("3rd place: " + top3Names.get(2));
    }
}
