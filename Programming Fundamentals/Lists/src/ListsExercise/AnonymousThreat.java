package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("3:1"))    {
            String [] command = input.split(" ");
            switch (command[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex >= inputList.size())   {
                        endIndex = inputList.size() - 1;
                    }
                    String tempString = "";
                    for (int i = startIndex; i <= endIndex; i++) {
                        tempString += inputList.get(i);
                    }
                    inputList.removeAll(inputList.subList(startIndex, endIndex + 1));
                    inputList.add(0, tempString);
                    break;
                case "divide":
                    int index = Integer.parseInt(command[1]);
                    int partitions = Integer.parseInt(command[2]);
                    String currentElement = inputList.get(index);
                    if (currentElement.length() % partitions == 0)  {

                    }
                    break;
            }
        }
    }
}
