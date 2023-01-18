package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Long> countries = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> cities = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] inputString = input.split("\\|");
            String city = inputString[0];
            String country = inputString[1];
            long population = Integer.parseInt(inputString[2]);

            countries.putIfAbsent(country, 0L);
            long countryPopulation = countries.get(country);
            countryPopulation += population;
            countries.put(country, countryPopulation);

            cities.putIfAbsent(country, new LinkedHashMap<>());
            cities.get(country).putIfAbsent(city, 0L);
            long cityPopulation = cities.get(country).get(city);
            cityPopulation += population;
            cities.get(country).put(city, cityPopulation);

            input = scanner.nextLine();
        }

        cities.entrySet().stream()
                .sorted((c1,c2)-> countries.get(c2.getKey()).compareTo(countries.get(c1.getKey())))
                .forEach(country ->{
                    System.out.printf("%s (total population: %d)%n",country.getKey(),countries.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city ->{
                                System.out.printf("=>%s: %d%n", city.getKey(),city.getValue());
                            });
                });
    }
}
