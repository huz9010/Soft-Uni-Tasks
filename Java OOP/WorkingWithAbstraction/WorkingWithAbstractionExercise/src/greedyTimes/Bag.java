package greedyTimes;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Bag {

    long capacity;
    long goldAmount;
    long gemsAmount;
    long cashAmount;
    LinkedHashMap<String, Item> items;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.goldAmount = 0;
        this.gemsAmount = 0;
        this.cashAmount = 0;
        this.items = new LinkedHashMap<>();
    }

    public void fillBag(Scanner scanner) {
        String[] itemsInSafe = scanner.nextLine().split("\\s+");

        for (int i = 0; i < itemsInSafe.length; i += 2) {
            String currentItem = itemsInSafe[i];
            long currentAmount = Long.parseLong(itemsInSafe[i + 1]);
            if (currentAmount <= 0) {
                continue;
            }
            if (isGold(currentItem)) {
                if (isItemsAmountValid(goldAmount + currentAmount, gemsAmount, cashAmount)) {
                    addItem(currentItem, currentAmount);
                    goldAmount += currentAmount;
                }
            } else if (isGem(currentItem)) {
                if (isItemsAmountValid(goldAmount, gemsAmount + currentAmount, cashAmount)) {
                    addItem(currentItem, currentAmount);
                    gemsAmount += currentAmount;
                }
            } else if (isCash(currentItem)) {
                if (isItemsAmountValid(goldAmount, gemsAmount, cashAmount + currentAmount)) {
                    addItem(currentItem, currentAmount);
                    cashAmount += currentAmount;
                }
            }
        }
    }

    private static boolean isGold(String currentItem) {
        return currentItem.equalsIgnoreCase("gold");
    }

    private static boolean isGem(String currentItem) {
        return currentItem.length() > 3 && currentItem.toLowerCase().endsWith("gem");
    }

    private static boolean isCash(String item) {
        return item.length() == 3;
    }

    private void addItem(String currentItem, long currentAmount) {
        if (items.containsKey(currentItem)) {
            Item itemToAdd = new Item(currentItem, items.get(currentItem).getAmount() + currentAmount);
            items.put(currentItem, itemToAdd);
        } else {
            items.put(currentItem, new Item(currentItem, currentAmount));
        }
    }

    public boolean isItemsAmountValid(long gold, long gems, long cash) {
        return gold >= gems && gems >= cash && gold + gems + cash <= capacity;
    }

    public void printBag() {
        if (goldAmount > 0) {
            System.out.printf("<Gold> $%d%n", goldAmount);
            System.out.printf("##Gold - %d%n", goldAmount);
        }

        if (gemsAmount > 0) {
            System.out.printf("<Gem> $%d%n", gemsAmount);

            items.entrySet().stream().filter(e -> e.getValue().getType().toLowerCase().endsWith("gem"))
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(e -> System.out.println(e.getValue()));
        }

        if (cashAmount > 0) {
            System.out.printf("<Cash> $%d%n", cashAmount);

            items.entrySet().stream().filter(e -> e.getValue().getType().length() == 3)
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(e -> System.out.println(e.getValue()));
        }

    }
}