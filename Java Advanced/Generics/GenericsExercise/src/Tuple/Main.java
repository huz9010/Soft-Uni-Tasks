package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        Tuple<String, String> firstTuple = new Tuple<>(name, address);

        input = scanner.nextLine().split("\\s+");
        name = input[0];
        int littersOfBeer = Integer.parseInt(input[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(name, littersOfBeer);

        input = scanner.nextLine().split("\\s+");
        int intNum = Integer.parseInt(input[0]);
        double doubleNum = Double.parseDouble(input[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(intNum, doubleNum);

        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);
    }
}
