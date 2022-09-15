package ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add":
                    int num = Integer.parseInt(command[1]);
                    numList.add(num);
                    break;
                case "Insert":
                    num = Integer.parseInt(command[1]);
                    int index = Integer.parseInt(command[2]);
                    if (index > numList.size() || index < 0)    {
                        System.out.println("Invalid index");
                        input = scanner.nextLine();
                        continue;
                    }   else {
                        numList.add(index, num);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(command[1]);
                    if (index >= numList.size() || index < 0)    {
                        System.out.println("Invalid index");
                        input = scanner.nextLine();
                        continue;
                    }   else {
                        numList.remove(index);
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    if (count > numList.size()) {
                        count = count % numList.size();
                    }
                        if (command[1].equals("left")) {
                            List<Integer> tempList1 = new ArrayList<>(numList.subList(count, numList.size()));
                            List<Integer> tempList2 = new ArrayList<>(numList.subList(0, count));
                            numList.clear();
                            numList.addAll(tempList1);
                            numList.addAll(tempList2);

                        } else if (command[1].equals("right")) {
                            List<Integer> tempList1 = new ArrayList<>(numList.subList(numList.size() - count, numList.size()));
                            List<Integer> tempList2 = new ArrayList<>(numList.subList(0, numList.size() - count));
                            numList.clear();
                            numList.addAll(tempList1);
                            numList.addAll(tempList2);
                        }

                    break;
            }

            input = scanner.nextLine();
        }
        for (int element : numList) {
            System.out.print(element + " ");
        }
    }
}
