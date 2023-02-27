package food_shortage;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (input.length == 3)  {
                buyers.put(name, new Rebel(name, age, input[2]));
            }   else {
                buyers.put(name, new Citizen(name, age, input[2], input[3]));
            }
        }

        String buyer = scanner.nextLine();

        while (!buyer.equals("End"))    {
            if (buyers.containsKey(buyer)) {
                buyers.get(buyer).buyFood();
            }
            buyer = scanner.nextLine();
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
