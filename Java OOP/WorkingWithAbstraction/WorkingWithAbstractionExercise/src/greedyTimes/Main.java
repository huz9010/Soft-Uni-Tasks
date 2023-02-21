
package greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bag bag = new Bag(Long.parseLong(scanner.nextLine()));

        bag.fillBag(scanner);

        bag.printBag();
    }
}