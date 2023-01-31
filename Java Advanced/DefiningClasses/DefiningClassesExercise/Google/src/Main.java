import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] line = input.split("\\s+");
            String name = line[0];
            String objectName = line[2];
            String data = line[3];

            Person person = new Person(name);
            people.putIfAbsent(name, person);

            switch (line[1])    {
                case "company":
                    double salary = Double.parseDouble(line[4]);
                    people.get(name).setCompany(objectName, data, salary);
                    break;

                case "pokemon":
                    people.get(name).setPokemons(objectName, data);
                    break;

                case "parents":
                    people.get(name).setParents(objectName, data);
                    break;

                case "children":
                    people.get(name).setChildren(objectName, data);
                    break;

                case "car":
                    int speed = Integer.parseInt(data);
                    people.get(name).setCar(objectName, speed);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid data!");
            }


            input = scanner.nextLine();
        }

        String personToPrint = scanner.nextLine();

        people.get(personToPrint).printPerson();
    }
}
