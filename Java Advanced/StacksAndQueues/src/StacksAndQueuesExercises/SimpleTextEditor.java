package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder string = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];
            String tempString = "";

            switch (command)    {
                case "1":
                    String stringToAppend = input.split("\\s+")[1];
                    tempString = String.valueOf(string);
                    stack.push(tempString);
                    string.append(stringToAppend);
                    break;
                case "2":
                    int count = Integer.parseInt(input.split("\\s+")[1]);
                    tempString = String.valueOf(string);
                    stack.push(tempString);
                    string.delete(string.length() - count, string.length());
                    break;
                case "3":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    System.out.println(string.charAt(index - 1));
                    break;
                case "4":
                    string = new StringBuilder(stack.pop());
                    break;
            }
        }
    }
}
