package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int enqueueElements = Integer.parseInt(input[0]);
        int dequeueElements = Integer.parseInt(input[1]);
        int checkElement = Integer.parseInt(input[2]);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < enqueueElements; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 1; i <= dequeueElements; i++) {
            queue.poll();
        }

        if (queue.isEmpty())    {
            System.out.println(0);
        }   else {
            if (queue.contains(checkElement))   {
                System.out.println("true");
            }   else {
                System.out.println(minElementInQueue(queue));
            }
        }
    }

    public static int minElementInQueue (ArrayDeque<Integer> queue)   {
        int min = Integer.MAX_VALUE;

        for (Integer num : queue) {
            if (num < min)  {
                min = num;
            }
        }
        return min;
    }
}
