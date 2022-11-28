package FinalExam05;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate"))   {
            String[] inputCommand = input.split(">>>");
            String command = inputCommand[0];

            switch (command) {
                case "Contains":
                    String substring = inputCommand[1];

                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperLower = inputCommand[1];
                    int startIndex = Integer.parseInt(inputCommand[2]);
                    int endIndex = Integer.parseInt(inputCommand[3]);

                    String substringTemp = "";
                    if (upperLower.equals("Upper")) {
                        substringTemp = activationKey.substring(startIndex, endIndex).toUpperCase();
                        activationKey = activationKey.replace(activationKey.substring(startIndex, endIndex), substringTemp);
                    } else {
                        substringTemp = activationKey.substring(startIndex, endIndex).toLowerCase();
                        activationKey = activationKey.replace(activationKey.substring(startIndex, endIndex), substringTemp);
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int firstIndex = Integer.parseInt(inputCommand[1]);
                    int lastIndex = Integer.parseInt(inputCommand[2]);
                    activationKey = new StringBuilder(activationKey).delete(firstIndex, lastIndex).toString();

                    System.out.println(activationKey);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}
