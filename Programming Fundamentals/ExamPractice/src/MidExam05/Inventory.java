package MidExam05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] command = input.split(" - ");
            String item = command[1];
            switch (command[0]) {
                case "Collect":
                    if (!inventory.contains(item))  {
                        inventory.add(item);
                    }
                    break;
                case "Drop":
                    inventory.remove(item);
                    break;
                case "Combine Items":
                    String[] items = item.split(":");
                    if (inventory.contains(items[0]))   {
                        int index = inventory.indexOf(items[0]);
                        inventory.add(index + 1, items[1]);
                    }
                    break;
                case "Renew":
                    if (inventory.contains(item))   {
                        inventory.remove(item);
                        inventory.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", inventory));
    }
}
