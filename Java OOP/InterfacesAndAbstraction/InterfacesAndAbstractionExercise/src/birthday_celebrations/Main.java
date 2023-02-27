package birthday_celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] inputData = input.split("\\s+");
            String type = inputData[0];

            switch (type)   {
                case "Citizen":
                    String name = inputData[1];
                    int age = Integer.parseInt(inputData[2]);
                    String id = inputData[3];
                    String birthDate = inputData[4];

                    birthables.add(new Citizen(name, age, id, birthDate));
                    break;
                case "Robot":
                    break;
                case "Pet":
                    name = inputData[1];
                    birthDate = inputData[2];
                    birthables.add(new Pet(name, birthDate));
                    break;
            }
            input = scanner.nextLine();
        }

        String yearToFilter = scanner.nextLine();
        birthables.stream().map(Birthable::getBirthDate).filter(e -> e.endsWith(yearToFilter)).forEach(System.out::println);
    }
}
