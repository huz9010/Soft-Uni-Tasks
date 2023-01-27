package ExamJune2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(milkQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(cacaoStack::push);

        TreeMap<String, Integer> chocolatesMade = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty())   {
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();

            double percentage = (cacao / (cacao + milk)) * 100;

            if (percentage == 30)   {
                String chocolate = "Milk Chocolate";
                makeChocolate(chocolatesMade, chocolate);

            } else if (percentage == 50) {
                String chocolate = "Dark Chocolate";
                makeChocolate(chocolatesMade, chocolate);

            } else if (percentage == 100) {
                String chocolate = "Baking Chocolate";
                makeChocolate(chocolatesMade, chocolate);

            } else {
                milk += 10;
                milkQueue.offer(milk);
            }
        }

        if (chocolatesMade.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }   else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolatesMade.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
    }

    private static void makeChocolate(TreeMap<String, Integer> chocolatesMade, String chocolate) {
        if (chocolatesMade.containsKey(chocolate))   {
            int count = chocolatesMade.get(chocolate) + 1;
            chocolatesMade.put(chocolate, count);
        }   else {
            chocolatesMade.put(chocolate, 1);
        }
    }
}
