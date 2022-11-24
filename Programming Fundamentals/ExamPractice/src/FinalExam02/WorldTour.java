package FinalExam02;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Travel"))  {
            String[] inputCommand = input.split(":");
            String command = inputCommand[0];

            switch (command)    {
                case "Add Stop":
                    int index = Integer.parseInt(inputCommand[1]);
                    String string = inputCommand[2];
                    if (index >= 0 && index < stops.length())    {
                        stops.insert(index, string);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(inputCommand[1]);
                    int endIndex = Integer.parseInt(inputCommand[2]);
                    if (startIndex <= endIndex && startIndex >= 0 && endIndex < stops.length())     {
                        stops.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = inputCommand[1];
                    String newString = inputCommand[2];
                    if (stops.toString().contains(oldString)) {
                            stops = new StringBuilder(stops.toString().replace(oldString, newString));
                    }
                    System.out.println(stops);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }
}
