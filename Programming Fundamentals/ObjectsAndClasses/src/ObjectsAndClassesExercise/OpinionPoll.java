package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    static class Person {
        String name;
        String age;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public String getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < persons; i++) {
            Person currentPerson = new Person();
            String[] personData = scanner.nextLine().split(" ");
            currentPerson.setName(personData[0]);
            currentPerson.setAge(personData[1]);
            personList.add(currentPerson);
        }
        for (Person person : personList)    {
            if (Integer.parseInt(person.getAge()) > 30) {
                System.out.printf("%s - %s%n", person.getName(), person.getAge());
            }
        }
    }
}
