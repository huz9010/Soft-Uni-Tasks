package MidExamOct23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chatLog = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end"))    {
            String command = input.split(" ")[0];
            String message = input.split(" ")[1];

            switch (command)    {
                case "Chat":
                    chatLog.add(message);
                    break;
                case "Delete":
                    chatLog.remove(message);
                    break;
                case "Edit":
                    String editedMessage = input.split(" ")[2];
                    if (chatLog.contains(message))  {
                        int index = chatLog.indexOf(message);
                        chatLog.set(index, editedMessage);
                    }
                    break;
                case "Pin":
                    if (chatLog.contains(message))  {
                        chatLog.remove(message);
                        chatLog.add(message);
                    }
                    break;
                case "Spam":
                    String[] spamMessages = input.split(" ");
                    for (int i = 1; i < spamMessages.length; i++) {
                        chatLog.add(spamMessages[i]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (String element : chatLog)  {
            System.out.println(element);
        }
    }
}
