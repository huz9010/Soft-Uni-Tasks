package StackIterator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();
        String input = scanner.nextLine();

        while (!input.equals("END"))    {

            String[] command = input.split("(\\s+)|(,\\s+)");

            if (command[0].equals("Pop"))    {
                try {
                    stack.pop();
                }   catch (NoSuchElementException e)    {
                    System.out.println(e.getMessage());
                }

            } else if (command[0].equals("Push")) {
                Integer[] nums = Arrays.stream(command).filter(e -> Character.isDigit(e.charAt(0))).map(Integer::parseInt).toArray(Integer[]::new);
                 stack.push(nums);
            }

            input = scanner.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
