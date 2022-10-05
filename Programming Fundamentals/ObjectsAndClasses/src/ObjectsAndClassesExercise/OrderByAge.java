package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Person {
        private String name;
        private String id;
        private int age;

        public void setPerson(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public String getId() {
            return this.id;
        }

        public int getAge() {
            return this.age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End"))    {
            String[] personData = input.split(" ");
            String name = personData[0];
            String id = personData[1];
            int age = Integer.parseInt(personData[2]);

            Person currentPerson = new Person();
            currentPerson.setPerson(name, id, age);
            peopleList.add(currentPerson);

            input = scanner.nextLine();
        }
        peopleList.sort(Comparator.comparingInt(Person::getAge));
        for (Person people : peopleList)    {
            System.out.printf("%s with ID: %s is %d years old.%n", people.getName(), people.getId(), people.getAge());
        }
    }
}
