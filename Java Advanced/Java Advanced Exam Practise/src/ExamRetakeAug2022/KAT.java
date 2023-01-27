package ExamRetakeAug2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Long> platesQueue = new ArrayDeque<>();
        ArrayDeque<Long> carsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).forEach(e -> platesQueue.offer(Long.valueOf(e)));
        Arrays.stream(scanner.nextLine().split(", ")).forEach(e -> carsStack.push(Long.valueOf(e)));

        long days = 0;
        long carsRegistered = 0;

        while (!platesQueue.isEmpty() && !carsStack.isEmpty()) {
            days++;
            long plates = platesQueue.poll();
            long cars = carsStack.pop();

            if (plates > (cars * 2)) {
                plates -= cars * 2;
                carsRegistered += cars;
                platesQueue.addLast(plates);
            } else if ((cars * 2) > plates) {
                cars -= plates / 2;
                carsRegistered += plates / 2;
                carsStack.addLast(cars);
            } else {
                carsRegistered += cars;
            }
        }

        System.out.printf("%d cars were registered for %d days!%n", carsRegistered, days);

        if (!platesQueue.isEmpty()) {
            long remainingPlates = 0;

            while (!platesQueue.isEmpty())  {
                remainingPlates += platesQueue.poll();
            }
            System.out.printf("%d license plates remain!", remainingPlates);
        } else if (!carsStack.isEmpty()) {
            long remainingcars = 0;
            while (!carsStack.isEmpty())  {
                remainingcars += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!", remainingcars);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
