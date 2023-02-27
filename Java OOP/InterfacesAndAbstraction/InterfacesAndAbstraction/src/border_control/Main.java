package border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> citizensAndRobots = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] inputData = input.split("\\s+");

            if (inputData.length == 2)  {
                String model = inputData[0];
                String id = inputData[1];
                citizensAndRobots.add(new Robot(model, id));
            }   else {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                citizensAndRobots.add(new Citizen(name, age, id));
            }
            input = scanner.nextLine();
        }
        String falseId = scanner.nextLine();

        citizensAndRobots.stream().filter(e -> e.getId().endsWith(falseId)).forEach(System.out::println);

        Citizen citizen = new Citizen("name", 16, "12345");
        System.out.println(citizen.getId());
    }
}
