package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String currentUrl = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {

                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    if (!currentUrl.equals("")) {
                        forward.push(currentUrl);
                    }
                    currentUrl = stack.pop();
                }

            } else if (input.equals("forward")) {

                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    if (!currentUrl.equals("")) {
                        stack.push(currentUrl);
                    }
                    currentUrl = forward.pop();
                }

            } else {

                if (!currentUrl.equals("")) {
                    stack.push(currentUrl);
                }

                currentUrl = input;
            }
            if (!currentUrl.equals("")) {
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}