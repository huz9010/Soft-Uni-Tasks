package SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> countries = new LinkedHashMap<>();

        for (int i = 0; i < linesCount; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            countries.putIfAbsent(continent, new LinkedHashMap<>());
            countries.get(continent).putIfAbsent(country, new ArrayList<>());
            countries.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : countries.entrySet()) {
            System.out.println(continent.getKey() + ":");

            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.print("  " + country.getKey() + " -> ");

                System.out.println(String.join(", ", country.getValue()));
            }
        }
    }
}
