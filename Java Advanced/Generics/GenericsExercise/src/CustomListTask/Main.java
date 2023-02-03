package CustomListTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> list = new CustomList<>();

        while (!input.equals("END"))    {
            String[] inputParts = input.split("\\s+");

            String command = inputParts[0];

            switch (command)    {
                case "Add":
                    String element = inputParts[1];
                    list.add(element);
                    break;

                case "Remove":
                    int index = Integer.parseInt(inputParts[1]);
                    list.remove(index);
                    break;

                case "Contains":
                    element = inputParts[1];
                    System.out.println(list.contains(element));
                    break;

                case "Swap":
                    int firstIndex = Integer.parseInt(inputParts[1]);
                    int secondIndex = Integer.parseInt(inputParts[2]);
                    list.swap(firstIndex, secondIndex);
                    break;

                case "Greater":
                    element = inputParts[1];
                    System.out.println(list.countGreaterThan(element));
                    break;

                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + command);
            }

            input = scanner.nextLine();
        }
    }
}
