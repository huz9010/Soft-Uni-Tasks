package RetakeExamAug2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> liquidsQueue.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> ingredientsStack.push(Integer.parseInt(e)));

        LinkedHashMap<String, Integer> foodCooked = new LinkedHashMap<>();
        foodCooked.put("Biscuit", 0);
        foodCooked.put("Cake", 0);
        foodCooked.put("Pie", 0);
        foodCooked.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty())  {

            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();

            int sum = liquid + ingredient;
            String food = "";

            switch (sum)    {
                case 25:
                    food = "Biscuit";
                    cookFood(foodCooked, food);
                    break;
                case 50:
                    food = "Cake";
                    cookFood(foodCooked, food);
                    break;
                case 75:
                    food = "Pastry";
                    cookFood(foodCooked, food);
                    break;
                case 100:
                    food = "Pie";
                    cookFood(foodCooked, food);
                    break;
                default:
                    ingredient += 3;
                    ingredientsStack.push(ingredient);
            }
        }

        System.out.println(allCooked(foodCooked) ? "Great! You succeeded in cooking all the food!"
                : "What a pity! You didn't have enough materials to cook everything.");

        System.out.print("Liquids left: ");
        if (liquidsQueue.isEmpty()) {
            System.out.println("none");
        }   else {
            System.out.println(liquidsQueue.stream().collect(Collectors.toList()).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.print("Ingredients left: ");
        if (ingredientsStack.isEmpty()) {
            System.out.println("none");
        }   else {
            System.out.println(ingredientsStack.stream().collect(Collectors.toList()).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        for (Map.Entry<String, Integer> food : foodCooked.entrySet()) {
            System.out.printf("%s: %s%n", food.getKey(), food.getValue());
        }
    }



    private static boolean allCooked(LinkedHashMap<String, Integer> foodCooked) {
        for (Map.Entry<String, Integer> food : foodCooked.entrySet()) {
            if (food.getValue() == 0)   {
                return false;
            }
        }
        return true;
    }

    private static void cookFood(LinkedHashMap<String, Integer> foodCooked, String food) {
        int count = foodCooked.get(food) + 1;
        foodCooked.put(food, count);
    }
}
