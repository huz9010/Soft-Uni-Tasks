package FinalExam02;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plantCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> plantsList = new LinkedHashMap<>();

        for (int i = 1; i <= plantCount; i++) {
            String[] plantInfo = scanner.nextLine().split("<->");
            Integer rarity = Integer.parseInt(plantInfo[1]);

            List<Integer> rarityRating = new ArrayList<>();
            rarityRating.add(rarity);

            plantsList.put(plantInfo[0], rarityRating);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition"))     {
            String[] inputCommand = input.split(": | - ");
            String command = inputCommand[0];
            String plant = inputCommand[1];
            if (plantsList.containsKey(plant)) {
                switch (command) {
                    case "Rate":
                        Integer rating = Integer.parseInt(inputCommand[2]);
                        plantsList.get(plant).add(rating);
                        break;
                    case "Update":
                        Integer rarity = Integer.parseInt(inputCommand[2]);
                        plantsList.get(plant).set(0, rarity);
                        break;
                    case "Reset":
                            plantsList.get(plant).removeAll(plantsList.get(plant).subList(1, plantsList.get(plant).size()));
                        break;
                }
            }   else {
                System.out.println("error");
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Integer>> entry : plantsList.entrySet()) {
            int totalRating = 0;

            for (int i = 1; i < entry.getValue().size(); i++) {
                totalRating += entry.getValue().get(i);
            }
                double averageRating = 0;
                if (totalRating == 0) {
                    averageRating = 0;
                } else {
                    averageRating = totalRating * 1.0 / (entry.getValue().size() - 1);
                }
                System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0), averageRating);
        }
    }
}
