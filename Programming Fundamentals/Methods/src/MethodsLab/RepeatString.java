package MethodsLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeat = Integer.parseInt(scanner.nextLine());
        String result = repeatString(input, repeat);

        System.out.println(result);
    }

    public static String repeatString (String input, int repeat)    {
        String result = "";
        for (int i = 1; i <= repeat; i++) {
            result = result + input;
        }
        return result;
    }
}
