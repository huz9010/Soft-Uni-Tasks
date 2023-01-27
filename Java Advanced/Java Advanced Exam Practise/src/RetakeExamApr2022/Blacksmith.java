package RetakeExamApr2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> steelQueue.offer(Integer.valueOf(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> carbonStack.push(Integer.valueOf(e)));

        TreeMap<String, Integer> swords = new TreeMap<>();
        int totalSwords = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int resources = steel + carbon;
            String sword = null;
            switch (resources)  {
                case 70:
                    sword = "Gladius";
                    totalSwords = forgeSword(swords, totalSwords, sword);
                    break;
                case 80:
                    sword = "Shamshir";
                    totalSwords = forgeSword(swords, totalSwords, sword);
                    break;
                case 90:
                    sword = "Katana";
                    totalSwords = forgeSword(swords, totalSwords, sword);
                    break;
                case 110:
                    sword = "Sabre";
                    totalSwords = forgeSword(swords, totalSwords, sword);
                    break;
                default:
                    carbonStack.push(carbon + 5);
            }
        }

        if (swords.isEmpty())   {
            System.out.println("You did not have enough resources to forge a sword.");
        }   else {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        }

        printResourcesLeft("Steel left: ", steelQueue);
        printResourcesLeft("Carbon left: ", carbonStack);

        swords.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static void printResourcesLeft(String s, ArrayDeque<Integer> steelQueue) {
        System.out.print(s);
        if (steelQueue.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(steelQueue.stream().collect(Collectors.toList()).stream().map(Objects::toString).collect(Collectors.joining(", ")));
        }
    }

    private static int forgeSword(TreeMap<String, Integer> swords, int totalSwords, String sword) {
        totalSwords++;
        if (swords.containsKey(sword))  {
            int count = swords.get(sword) + 1;
            swords.put(sword, count);
        }   else {
            swords.put(sword, 1);
        }
        return totalSwords;
    }
}
