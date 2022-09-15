package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalWater = 0;

        for (int i = 1; i <= n; i++) {
            int water = Integer.parseInt(scanner.nextLine());
            totalWater += water;
            if (totalWater > 255)   {
                System.out.println("Insufficient capacity!");
                totalWater -= water;
            }
        }
        System.out.println(totalWater);
    }
}
