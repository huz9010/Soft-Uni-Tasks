package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isWonLegendary = false;
        LinkedHashMap<String, Integer> materialsMap = new LinkedHashMap<>();
        materialsMap.put("shards", 0);
        materialsMap.put("fragments", 0);
        materialsMap.put("motes", 0);

        while (!isWonLegendary) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i+=2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (materialsMap.containsKey(material)) {
                    quantity = materialsMap.get(material) + quantity;
                }
                materialsMap.put(material, quantity);

                if (materialsMap.get("shards") >= 250)  {
                    int tempShards = materialsMap.get("shards") - 250;
                    materialsMap.put("shards", tempShards);
                    System.out.println("Shadowmourne obtained!");
                    isWonLegendary= true;
                    break;

                } else if (materialsMap.get("fragments") >= 250) {
                    int tempFragments = materialsMap.get("fragments") - 250;
                    materialsMap.put("fragments", tempFragments);
                    System.out.println("Valanyr obtained!");
                    isWonLegendary = true;
                    break;

                }   else if (materialsMap.get("motes") >= 250)  {
                    int tempMotes = materialsMap.get("motes") - 250;
                    materialsMap.put("motes", tempMotes);
                    System.out.println("Dragonwrath obtained!");
                    isWonLegendary = true;
                    break;
                }
            }

        }

        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
