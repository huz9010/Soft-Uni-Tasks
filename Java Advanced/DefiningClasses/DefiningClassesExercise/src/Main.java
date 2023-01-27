import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] personData = scanner.nextLine().split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream().filter(p -> p.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(e -> System.out.printf("%s - %d%n", e.getName(), e.getAge()));
    }
}
