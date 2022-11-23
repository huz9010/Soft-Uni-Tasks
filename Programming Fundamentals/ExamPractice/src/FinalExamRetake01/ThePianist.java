package FinalExamRetake01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int piecesCount = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> piecesList = new LinkedHashMap<>();

        for (int i = 1; i <= piecesCount; i++) {
            String input = scanner.nextLine();
            String[] composerKey = {input.split("\\|")[1], input.split("\\|")[2]};
            piecesList.put(input.split("\\|")[0], composerKey);
        }

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("Stop"))    {
            String[] input = inputCommand.split("\\|");

            switch (input[0])   {
                case "Add":
                    if (piecesList.containsKey(input[1]))   {
                        System.out.println(input[1] + " is already in the collection!");
                    }   else {
                        String[] composerKey = {input[2], input[3]};
                        piecesList.put(input[1], composerKey);
                        System.out.printf("%s by %s in %s added to the collection!%n", input[1], input[2], input[3]);
                    }
                    break;
                case "Remove":
                    if (!piecesList.containsKey(input[1]))   {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", input[1]);
                    }   else {
                        piecesList.remove(input[1]);
                        System.out.printf("Successfully removed %s!%n", input[1]);
                    }
                    break;
                case "ChangeKey":
                    if (!piecesList.containsKey(input[1]))   {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", input[1]);
                    }   else {
                        String[] temp = {piecesList.get(input[1])[0], input[2]};
                        piecesList.replace(input[1], temp);
                        System.out.printf("Changed the key of %s to %s!%n", input[1], input[2]);
                    }

                    break;
            }
            inputCommand = scanner.nextLine();
        }
        for (Map.Entry<String, String[]> entry : piecesList.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }

    }
}
