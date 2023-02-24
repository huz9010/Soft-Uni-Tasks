package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!input.equals("Beast!")) {
            String[] animalData = scanner.nextLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            try {
                switch (input) {
                    case "Dog":
                        animals.add(new Dog(name, age, gender));
                        break;
                    case "Frog":
                        animals.add(new Frog(name, age, gender));
                        break;
                    case "Cat":
                        animals.add(new Cat(name, age, gender));
                        break;
                    case "Kitten":
                        animals.add(new Kitten(name, age));
                        break;
                    case "Tomcat":
                        animals.add(new Tomcat(name, age));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid animal type " + input);
                }
            }   catch (IllegalArgumentException e)  {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }
}
