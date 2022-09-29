package MidExam04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!"))   {
            String[] command = input.split(" ");
            String item = "";
            switch (command[0]) {
                case "Urgent":
                    item = command[1];
                    if (!shoppingList.contains(item))   {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    item = command[1];
                    shoppingList.remove(item);
                    break;
                case "Correct":
                    String oldItem = command[1];
                    String newItem = command[2];
                    if (shoppingList.contains(oldItem)) {
                        shoppingList.set(shoppingList.indexOf(oldItem), newItem);
                    }
                    break;
                case "Rearrange":
                    item = command[1];
                    if (shoppingList.contains(item))    {
                        int itemIndex = shoppingList.indexOf(item);
                        shoppingList.add(item);
                        shoppingList.remove(itemIndex);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));
    }
}
