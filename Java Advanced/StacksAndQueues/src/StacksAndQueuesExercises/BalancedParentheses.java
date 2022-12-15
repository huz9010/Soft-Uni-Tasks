package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> opening = new ArrayDeque<>();

        boolean isBalanced = true;

        if (input.length() < 2)  {
            isBalanced = false;
        } else if (input.charAt(0) == ')' || input.charAt(0) == ']' || input.charAt(0) == '}') {
            isBalanced = false;
        } else {

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                    opening.push(currentChar);
                }

                if (opening.isEmpty())  {
                    isBalanced = false;
                    break;
                }

                switch (currentChar) {
                    case ')':
                        if (opening.pop() != '(') {
                            isBalanced = false;
                        }
                        break;
                    case ']':
                        if (opening.pop() != '[') {
                            isBalanced = false;
                        }
                        break;
                    case '}':
                        if (opening.pop() != '{') {
                            isBalanced = false;
                        }
                        break;
                }
            }
        }

        if (!opening.isEmpty()) {
            isBalanced = false;
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
