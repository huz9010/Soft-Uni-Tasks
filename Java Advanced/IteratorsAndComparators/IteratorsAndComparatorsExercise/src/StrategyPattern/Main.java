package StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> sortedByName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> sortedByAge = new TreeSet<>(new PersonAgeComparator());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");

            sortedByName.add(new Person(personData[0], Integer.parseInt(personData[1])));
            sortedByAge.add(new Person(personData[0], Integer.parseInt(personData[1])));
        }

        for (Person person : sortedByName)  {
            System.out.println(person);
        }

        for (Person person : sortedByAge)  {
            System.out.println(person);
        }
    }
}
