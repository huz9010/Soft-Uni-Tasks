package pizza_calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pizzaName = "";
        int toppings = 0;
        String[] pizzaInput = scanner.nextLine().split("\\s+");
        if (pizzaInput.length > 2) {
            pizzaName = pizzaInput[1];
            toppings = Integer.parseInt(pizzaInput[2]);
        }   else {
            toppings = Integer.parseInt(pizzaInput[1]);
        }

        String[] doughInput = scanner.nextLine().split("\\s+");
        String flourType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double weight = Double.parseDouble(doughInput[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, toppings);
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);
            String input = scanner.nextLine();
            while (!input.equals("END")) {
                String[] toppingInput = input.split("\\s+");
                String toppingType = toppingInput[1];
                double toppingWeight = Double.parseDouble(toppingInput[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
                input = scanner.nextLine();
            }

            System.out.println(pizza);

        }   catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
}
