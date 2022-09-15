package MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        orderCalc(input, quantity);
    }

    public static void orderCalc(String order, int quantity)    {
        double sum = 0;

        switch (order)  {
            case "coffee":
                sum = quantity * 1.5;
                break;
            case "water":
                sum = quantity * 1.0;
                break;
            case "coke":
                sum = quantity * 1.4;
                break;
            case "snacks":
                sum = quantity * 2.0;
                break;
        }
        System.out.printf("%.2f", sum);
    }
}
