package RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int messageCount = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 1; i <= messageCount; i++) {
            String message = scanner.nextLine();

            Pattern pattern = Pattern.compile("[SsTtAaRr]");
            Matcher matcher = pattern.matcher(message);

            int count = 0;
            while (matcher.find())  {
                count++;
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                decryptedMessage.append((char) (message.charAt(j) - count));
            }

            Pattern planetPattern = Pattern.compile("@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<attackType>[A|D])![^@\\-!:>]*->(?<soldiers>[0-9]+)");
            Matcher planetMatcher = planetPattern.matcher(decryptedMessage);

            if (planetMatcher.find()) {
                String planet = planetMatcher.group("planetName");

                if (planetMatcher.group("attackType").equals("A"))    {
                    attackedPlanets.add(planet);
                }   else {
                    destroyedPlanets.add(planet);
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        for (String attackedPlanet : attackedPlanets) {
            System.out.printf("-> %s%n", attackedPlanet);
        }

        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        for (String destroyedPlanet : destroyedPlanets) {
            System.out.printf("-> %s%n", destroyedPlanet);
        }
    }
}
