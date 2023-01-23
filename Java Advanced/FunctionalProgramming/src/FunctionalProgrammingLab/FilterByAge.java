package FunctionalProgrammingLab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age)    {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int personCount = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> personReader = sc -> {
            String[] data = sc.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            return new Person(name, age);
        };

        List<Person> personList = IntStream.range(0, personCount).mapToObj(i -> personReader.apply(scanner)).collect(Collectors.toList());

        String condition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> filter = getFilter(condition, ageFilter);
        Consumer<Person> printer = getPrinter(format);

        personList.stream().filter(filter).forEach(printer);
    }

    private static Predicate<Person> getFilter(String condition, int ageFilter) {
        switch (condition)  {
            case "younger":
                return p -> p.age <= ageFilter;
            case "older":
                return p -> p.age >= ageFilter;
            default:
                throw new  IllegalArgumentException("Unknown condition" + condition);
        }
    }

    private static Consumer<Person> getPrinter(String format) {
        switch (format) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return  p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format: " + format);
        }
    }
}
