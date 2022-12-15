package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> opening = new ArrayDeque<>();
        ArrayDeque<Character> closing = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '(') {
                opening.push(input.charAt(i));
            }   else {
                closing.push(input.charAt(i));
            }
        }

        ArrayDeque<Character> reversedClosing = new ArrayDeque<>();

        for (Character ch : closing) {
            reversedClosing.push(ch);
        }

        for (Character character : opening) {
            if (character == '[' && reversedClosing.pop() != ']') {
                isBalanced = false;
            }
            if (character == '{' && reversedClosing.pop() != '}') {
                isBalanced = false;
            }
            if (character == '(' && reversedClosing.pop() != ')') {
                isBalanced = false;
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        }   else {
            System.out.println("NO");
        }
    }
}
