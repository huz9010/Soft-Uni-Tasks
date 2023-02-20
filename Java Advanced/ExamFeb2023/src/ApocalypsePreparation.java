import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textileQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(textileQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(medicamentStack::push);

        TreeMap<String, Integer> healingItems = new TreeMap<>();

        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int textile = textileQueue.poll();
            int medicament = medicamentStack.pop();

            int sum = textile + medicament;

            switch (sum) {
                case 30:
                    createItem(healingItems, "Patch");
                    break;
                case 40:
                    createItem(healingItems, "Bandage");
                    break;
                case 100:
                    createItem(healingItems, "MedKit");
                    break;
                default:
                    if (sum > 100) {
                        createItem(healingItems, "MedKit");
                        sum -= 100;
                        int tempMed = medicamentStack.pop() + sum;
                        medicamentStack.push(tempMed);
                    } else {
                        medicament += 10;
                        medicamentStack.push(medicament);
                    }
            }
        }

        if (textileQueue.isEmpty() && medicamentStack.isEmpty())    {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles are empty.");
        }

        healingItems.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));

        if (!medicamentStack.isEmpty()) {
            System.out.println("Medicaments left: " + medicamentStack.stream().collect(Collectors.toList())
                    .stream().map(Objects::toString).collect(Collectors.joining(", ")));
        }

        if (!textileQueue.isEmpty()) {
            System.out.println("Textiles left: " + textileQueue.stream().collect(Collectors.toList())
                    .stream().map(Objects::toString).collect(Collectors.joining(", ")));
        }
    }



    private static void createItem(TreeMap<String, Integer> healingItems, String item) {
        if (healingItems.containsKey(item)) {
            int medkits = healingItems.get(item);
            medkits++;
            healingItems.put(item, medkits);
        } else {
            healingItems.put(item, 1);
        }
    }
}
