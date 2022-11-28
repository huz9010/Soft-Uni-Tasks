package FinalExam05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputCity = scanner.nextLine();
        Map<String, Integer> cityPopulation = new LinkedHashMap<>();
        Map<String, Integer> cityGold = new LinkedHashMap<>();

        while (!inputCity.equals("Sail"))   {
            String city = inputCity.split("\\|{2}")[0];
            int population = Integer.parseInt(inputCity.split("\\|{2}")[1]);
            int gold = Integer.parseInt(inputCity.split("\\|{2}")[2]);

            if (cityPopulation.containsKey(city))   {
                int totalPopulation = cityPopulation.get(city) + population;
                cityPopulation.put(city, totalPopulation);

                int totalGold = cityGold.get(city) + gold;
                cityGold.put(city, totalGold);

            }   else {
                cityPopulation.put(city, population);
                cityGold.put(city, gold);
            }
                inputCity = scanner.nextLine();
        }

        String inputEvent = scanner.nextLine();

        while (!inputEvent.equals("End"))   {
            String command = inputEvent.split("=>")[0];
            String city = inputEvent.split("=>")[1];

            switch (command)    {
                case "Plunder":
                    int people = Integer.parseInt(inputEvent.split("=>")[2]);
                    int plunderedGold = Integer.parseInt(inputEvent.split("=>")[3]);

                    int remainingPopulation = cityPopulation.get(city) - people;
                    int remainingGold = cityGold.get(city) - plunderedGold;

                    cityPopulation.put(city, remainingPopulation);
                    cityGold.put(city, remainingGold);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, plunderedGold, people);

                    if (cityPopulation.get(city) <= 0 || cityGold.get(city) <= 0)  {
                        cityPopulation.remove(city);
                        cityGold.remove(city);

                        System.out.printf("%s has been wiped off the map!%n", city);
                    }
                    break;
                case "Prosper":
                    int goldAdded = Integer.parseInt(inputEvent.split("=>")[2]);
                    if (goldAdded < 0)  {
                        System.out.println("Gold added cannot be a negative number!");
                    }   else {
                        int totalGold = cityGold.get(city) + goldAdded;
                        cityGold.put(city, totalGold);

                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldAdded, city, cityGold.get(city));
                    }
                    break;
            }
            inputEvent = scanner.nextLine();
        }
        if (cityPopulation.isEmpty())   {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }   else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityGold.size());

            for (Map.Entry<String, Integer> entry : cityPopulation.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue(), cityGold.get(entry.getKey()));
            }
        }
    }
}
