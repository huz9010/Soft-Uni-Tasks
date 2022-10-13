package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex >= inputList.size()) {
                        input = scanner.nextLine();
                        continue;
                    }
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex >= inputList.size()) {
                        endIndex = inputList.size() - 1;
                    }

                    StringBuilder tempString = new StringBuilder();

                    for (int i = startIndex; i <= endIndex; i++) {
                        tempString.append(inputList.get(i));
                    }
                    inputList.removeAll(inputList.subList(startIndex, endIndex + 1));
                    inputList.add(startIndex, tempString.toString());
                    break;
                case "divide":
                    int index = Integer.parseInt(command[1]);
                    int partitions = Integer.parseInt(command[2]);
                    String currentElement = inputList.get(index);
                    int charsInPart = currentElement.length() / partitions;
                    List<String> equalStr = new ArrayList<>();

                    if (currentElement.length() % partitions == 0) {
                        for (int i = 0; i < currentElement.length(); i += charsInPart) {
                            String part = currentElement.substring(i, i + charsInPart);
                            equalStr.add(part);
                        }
                    } else {
                        int indexCounter = -1;
                        for (int i = 0; i < currentElement.length(); i+=charsInPart) {
                            String part = currentElement.substring(i, i + charsInPart);
                            equalStr.add(part);
                            indexCounter = i + charsInPart;
                            if (equalStr.size() == partitions - 1)  {
                                break;
                            }
                        }
                        equalStr.add(currentElement.substring(indexCounter));
                    }
                    inputList.remove(index);
                    inputList.addAll(index, equalStr);
                    break;
            }
            input = scanner.nextLine();
        }
        for (String element : inputList)    {
            System.out.print(element + " ");
        }
    }
}