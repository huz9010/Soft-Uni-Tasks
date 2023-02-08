package ExamOct2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> ingredientsQueue.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> freshnessStack.push(Integer.parseInt(e)));

        TreeMap<String, Integer> cocktailsMade = new TreeMap<>();
        boolean haveIngredients = true;

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredient = 0;
            int freshness = freshnessStack.pop();

            while (ingredient == 0) {
                if (ingredientsQueue.isEmpty()) {
                    haveIngredients = false;
                    break;
                }
                ingredient = ingredientsQueue.poll();
            }
            if (!haveIngredients)   {
                break;
            }

            int totalFreshness = ingredient * freshness;

            String cocktail = "";

            switch (totalFreshness) {
                case 150:
                    cocktail = "Pear Sour";
                    makeCocktail(cocktailsMade, cocktail);
                    break;
                case 250:
                    cocktail = "The Harvest";
                    makeCocktail(cocktailsMade, cocktail);
                    break;
                case 300:
                    cocktail = "Apple Hinny";
                    makeCocktail(cocktailsMade, cocktail);
                    break;
                case 400:
                    cocktail = "High Fashion";
                    makeCocktail(cocktailsMade, cocktail);
                    break;
                default:
                    ingredient += 5;
                    ingredientsQueue.offer(ingredient);
            }
        }

        int ingredientsLeft = ingredientsQueue.stream().mapToInt(Integer::intValue).sum();

        System.out.println(cocktailsMade.size() >= 4 ? "It's party time! The cocktails are ready!"
                : "What a pity! You didn't manage to prepare all cocktails.");

        if (ingredientsLeft > 0)    {
            System.out.println("Ingredients left: " + ingredientsLeft);
        }

        cocktailsMade.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }

    private static void makeCocktail(TreeMap<String, Integer> cocktailsMade, String cocktailName) {
        int count;
        if (!cocktailsMade.containsKey(cocktailName)) {
            cocktailsMade.put(cocktailName, 1);
        }   else {
            count = cocktailsMade.get(cocktailName) + 1;
            cocktailsMade.put(cocktailName, count);
        }
    }
}
