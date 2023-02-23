package shopping_spree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        HashMap<String, Product> products = new HashMap<>();

        String[] inputPeople = scanner.nextLine().split(";");

        addPeople(people, inputPeople);

        String[] inputProducts = scanner.nextLine().split(";");
        addProducts(products, inputProducts);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] inputSplit = input.split("\\s+");
            String name = inputSplit[0];
            String product = inputSplit[1];

            if (people.containsKey(name))   {
                try {
                    people.get(name).buyProduct(products.get(product));
                }
                catch (IllegalArgumentException e)  {
                    System.out.println(e.getMessage());
                }
            }

            input = scanner.nextLine();
        }

        people.forEach((key, value) -> System.out.println(value));
    }

    private static void addProducts(HashMap<String, Product> products, String[] inputProducts) {
        for (String product : inputProducts) {
            try {
                Product productToAdd = new Product(product.split("=")[0].trim(), Double.parseDouble(product.split("=")[1]));
                products.putIfAbsent(product.split("=")[0].trim(), productToAdd);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addPeople(LinkedHashMap<String, Person> people, String[] inputPeople) {
        for (String person : inputPeople) {
            try {
                Person personToAdd = new Person(person.split("=")[0].trim(), Double.parseDouble(person.split("=")[1]));
                people.putIfAbsent(person.split("=")[0].trim(), personToAdd);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
