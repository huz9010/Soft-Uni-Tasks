package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int pushElements = Integer.parseInt(input[0]);
        int popElements = Integer.parseInt(input[1]);
        int checkElement = Integer.parseInt(input[2]);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < pushElements; i++) {
            stack.push(nums[i]);
        }
        for (int i = 1; i <= popElements; i++) {
            stack.pop();
        }

        if (stack.isEmpty())    {
            System.out.println(0);
        }   else {
            if (stack.contains(checkElement)) {
                System.out.println("true");
            } else {
                System.out.println(minElementInStack(stack));
            }
        }
    }

    public static int minElementInStack (ArrayDeque<Integer> stack)   {
        int min = Integer.MAX_VALUE;

        for (Integer num : stack) {
            if (num < min)  {
                min = num;
            }
        }
        return min;
    }
}
