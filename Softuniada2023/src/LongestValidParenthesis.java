import java.util.Scanner;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int size = s.length();

        int leftCounter = 0, rightCounter = 0;
        int longest = 0;

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '(') {
                leftCounter++;
            } else {
                rightCounter++;
            }

            if (leftCounter == rightCounter) {
                longest = Math.max(longest,
                        2 * rightCounter);
            } else if (rightCounter > leftCounter) {
                leftCounter = 0;
                rightCounter = 0;
            }
        }

        leftCounter = 0;
        rightCounter = 0;

        for (int i = size - 1; i >= 0; i--) {

            if (s.charAt(i) == '(') {
                leftCounter++;
            } else
                rightCounter++;

            if (leftCounter == rightCounter) {
                longest = Math.max(longest,
                        2 * leftCounter);
            } else if (leftCounter > rightCounter) {
                leftCounter = 0;
                rightCounter = 0;
            }
        }
        System.out.println(longest);
    }
}