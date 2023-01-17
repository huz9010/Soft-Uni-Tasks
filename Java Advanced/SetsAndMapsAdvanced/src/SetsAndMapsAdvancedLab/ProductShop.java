package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Double>> productShop = new TreeMap<>();

        while (!input.equals("Revision"))   {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

                productShop.putIfAbsent(shop, new LinkedHashMap<>());
                productShop.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> shop : productShop.entrySet()) {
            System.out.println(shop.getKey() + "->");

            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }
    }
}
