package FinalExamRetake03;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] inputCommand = input.split(":\\|:");
            String command = inputCommand[0];
            StringBuilder currentMessage = new StringBuilder();

            switch (command)    {
                case "InsertSpace":
                    int index = Integer.parseInt(inputCommand[1]);
                    currentMessage.append(message);
                   currentMessage.insert(index, " ");
                   message = currentMessage.toString();
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = inputCommand[1];
                    if (message.contains(substring))    {
                        currentMessage.append(message);
                        int substringIndex = currentMessage.indexOf(substring);
                        currentMessage.delete(substringIndex, substringIndex + substring.length());

                        StringBuilder reversedSubstring = new StringBuilder(substring).reverse();
                        currentMessage.append(reversedSubstring);
                        message = currentMessage.toString();
                        System.out.println(message);
                    }   else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String oldSubstring = inputCommand[1];
                    String newSubstring = inputCommand[2];
                    message = message.replace(oldSubstring, newSubstring);
                    System.out.println(message);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
