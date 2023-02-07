package EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> treePeople = new TreeSet<>();
        HashSet<Person> hashPeople = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");

            treePeople.add(new Person(personData[0], Integer.parseInt(personData[1])));
            hashPeople.add(new Person(personData[0], Integer.parseInt(personData[1])));
        }

        System.out.println(treePeople.size());
        System.out.println(hashPeople.size());
    }
}
