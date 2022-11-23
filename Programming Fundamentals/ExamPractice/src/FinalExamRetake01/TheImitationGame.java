package FinalExamRetake01;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] inputCommand = input.split("\\|");
            String command = inputCommand[0];

            switch (command)    {
                case "Move":
                    int letterCount = Integer.parseInt(inputCommand[1]);
                    String tempString = encryptedMessage.substring(0, letterCount);
                    encryptedMessage.delete(0, letterCount);
                    encryptedMessage.append(tempString);
                    break;

                case "Insert":
                    int insertIndex = Integer.parseInt(inputCommand[1]);
                    String insertValue = inputCommand[2];
                    encryptedMessage.insert(insertIndex, insertValue);
                    break;
                case "ChangeAll":
                    String toChange = inputCommand[1];
                    String replacement = inputCommand[2];
                    for (int i = 0; i < encryptedMessage.length(); i++) {
                        int index = -1;
                        index = encryptedMessage.indexOf(toChange);
                        if (index >= 0) {
                            encryptedMessage.replace(index, index + toChange.length(), replacement);
                            i--;
                        }   else {
                            break;
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }
}
