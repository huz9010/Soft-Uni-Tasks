package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= commandCount; i++) {
            String command = scanner.nextLine();

            if (command.charAt(0) == '1')   {
                int element = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(element);
            } else if (command.charAt(0) == '2') {
                stack.pop();
            } else if (command.charAt(0) == '3') {
                System.out.println(maxElementInStack(stack));
            }
        }
    }

    public static int maxElementInStack (ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;

        for (Integer num : stack) {
            if (num > max)  {
                max = num;
            }
        }
        return max;
    }
}
