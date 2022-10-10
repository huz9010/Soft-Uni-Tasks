package AssociativeArraysExercise;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, List<Double>> productMap = new LinkedHashMap<>();

        while (!input.equals("buy"))    {
            List<Double> priceAndQuantity = new ArrayList<>();
            String[] products = input.split(" ");
            String product = products[0];
            double price = Double.parseDouble(products[1]);
            double quantity = Double.parseDouble(products[2]);

            if (!productMap.containsKey(product))   {
                priceAndQuantity.add(price);
                priceAndQuantity.add(quantity);
                productMap.put(product, priceAndQuantity);
            }   else {
                priceAndQuantity.add(price);
                double currentQuantity = productMap.get(product).get(1) + quantity;
                priceAndQuantity.add(currentQuantity);
                productMap.put(product, priceAndQuantity);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<Double>> entry : productMap.entrySet()) {
            double totalPrice = entry.getValue().get(0) * entry.getValue().get(1);
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }

    }
}
