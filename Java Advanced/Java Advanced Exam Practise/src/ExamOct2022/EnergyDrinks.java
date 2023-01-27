package ExamOct2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeineMilligrams = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).forEach(e -> caffeineMilligrams.push(Integer.valueOf(e)));
        Arrays.stream(scanner.nextLine().split(", ")).forEach(e -> energyDrinks.offer(Integer.valueOf(e)));
        int totalCaffeine = 0;

        while (!caffeineMilligrams.isEmpty() && !energyDrinks.isEmpty())    {
            int caffeine = caffeineMilligrams.peek() * energyDrinks.peek();

            if (caffeine + totalCaffeine <= 300)    {
                totalCaffeine += caffeine;
                caffeineMilligrams.pop();
                energyDrinks.poll();
            }   else {
                caffeineMilligrams.pop();
                energyDrinks.offer(energyDrinks.poll());

                totalCaffeine -= 30;
                if (totalCaffeine < 0)  {
                    totalCaffeine = 0;
                }
            }
        }

        if (energyDrinks.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }   else {
            System.out.print("Drinks left: ");
            System.out.println(energyDrinks.stream().collect(Collectors.toList()).stream().map(Objects::toString).collect(Collectors.joining(", ")));
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);
    }
}
