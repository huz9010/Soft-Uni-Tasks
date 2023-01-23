package SetsAndMapsExercise;

import java.util.*;
import java.util.stream.Stream;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isLegendaryItemObtained = false;
        HashMap<String, Integer> keyMaterials = new HashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        while (!isLegendaryItemObtained) {
            String[] itemString = input.split("\\s+");
            for (int i = 0; i < itemString.length; i += 2) {
                int quantity = Integer.parseInt(itemString[i]);
                String item = itemString[i + 1].toLowerCase();

                getItems(keyMaterials, junk, quantity, item);
            }

            if (keyMaterials.get("shards") >= 250) {
                System.out.println("Shadowmourne obtained!");
                int shards = keyMaterials.get("shards") - 250;
                keyMaterials.put("shards", shards);
                isLegendaryItemObtained = true;
            } else if (keyMaterials.get("fragments") >= 250) {
                System.out.println("Valanyr obtained!");
                int fragments = keyMaterials.get("fragments") - 250;
                keyMaterials.put("fragments", fragments);
                isLegendaryItemObtained = true;
            } else if (keyMaterials.get("motes") >= 250) {
                System.out.println("Dragonwrath  obtained!");
                int motes = keyMaterials.get("motes") - 250;
                keyMaterials.put("motes", motes);
                isLegendaryItemObtained = true;
            } else
                input = scanner.nextLine();
        }


    }

    private static void getItems(HashMap<String, Integer> keyMaterials, TreeMap<String, Integer> junk, int quantity, String item) {
        if (item.equalsIgnoreCase("shards") || item.equalsIgnoreCase("fragments") || item.equalsIgnoreCase("motes")) {
            keyMaterials.putIfAbsent(item, 0);
            int currentQuantity = keyMaterials.get(item);
            currentQuantity += quantity;
            keyMaterials.put(item, currentQuantity);
        }   else {
            junk.putIfAbsent(item, 0);
            int currentQuantity = junk.get(item);
            currentQuantity += quantity;
            junk.put(item, currentQuantity);
        }
    }
}
