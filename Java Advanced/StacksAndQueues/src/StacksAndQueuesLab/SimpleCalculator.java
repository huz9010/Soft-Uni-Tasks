package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> reversedStack = new ArrayDeque<>();

        for (String token : tokens) {
            stack.push(token);
        }
        for (String s : stack) {
            reversedStack.push(stack.pop());
        }

        while (reversedStack.size() > 1)    {
            int firstNum = Integer.parseInt(reversedStack.pop());
            String operator = reversedStack.pop();
            int secondNum = Integer.parseInt(reversedStack.pop());

            if (operator.equals("+"))   {
               reversedStack.push(String.valueOf(firstNum + secondNum));
            }   else {
                reversedStack.push(String.valueOf(firstNum - secondNum));
            }
        }
        System.out.println(reversedStack.pop());
    }
}
