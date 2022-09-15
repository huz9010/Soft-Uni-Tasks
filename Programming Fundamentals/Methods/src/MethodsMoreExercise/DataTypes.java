package MethodsMoreExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType = scanner.nextLine();

        switch (dataType){
            case "int":
                int intInput = Integer.parseInt(scanner.nextLine());
                dataManipulator(intInput);
                break;
            case "real":
                double doubleInput = Double.parseDouble(scanner.nextLine());
                dataManipulator(doubleInput);
                break;
            case "string":
                String stringInput = scanner.nextLine();
                dataManipulator(stringInput);
                break;
        }
    }

    public static void dataManipulator(String input){
        System.out.println("$" + input + "$");
    }
    public static void dataManipulator(int input){
        System.out.println(input * 2);
    }
    public static void dataManipulator(double input){
        System.out.printf("%.2f", (input * 1.5));
    }
}
