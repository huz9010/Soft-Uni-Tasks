package RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split("\\s*,\\s*");

        Map<String, Integer> demonHealth = new LinkedHashMap<>();
        Map<String, Double> demonDamage = new LinkedHashMap<>();

        for (int i = 0; i < demons.length; i++) {
            String name = demons[i];
            int health = 0;
            double damage = 0;
            int multiplyCount = 0;
            int divisionCount = 0;

            Pattern healthPattern = Pattern.compile("([^0-9+\\-*/.]+)");
            Matcher healthMatcher = healthPattern.matcher(name);

            StringBuilder nameForHealth = new StringBuilder();
            while (healthMatcher.find()) {
                nameForHealth.append(healthMatcher.group());
            }
            for (int j = 0; j < nameForHealth.length(); j++) {
                health += nameForHealth.charAt(j);
            }
            demonHealth.put(name, health);

            Pattern damagePattern = Pattern.compile("(\\+{1}|\\-{1}(?=\\d))?\\d+\\.?\\d*");
            Matcher damageMatcher = damagePattern.matcher(name);


            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }

            String[] operators = name.split("[^/*]+");

            for (String s : operators) {
                char[] operatorChar = s.toCharArray();
                for (char sign : operatorChar) {
                    if (sign == '*') {
                        damage *= 2;
                    } else if (sign == '/') {
                        damage /= 2;
                    }
                }
            }
            demonDamage.put(name, damage);
        }

        for (Map.Entry<String, Integer> entry : demonHealth.entrySet()) {
            System.out.printf("%s - %d health, %.2f damage%n", entry.getKey(), entry.getValue(), demonDamage.get(entry.getKey()));
        }

    }
}