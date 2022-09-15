package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> command = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            switch (command.get(0)) {
                case "Contains":
                    int num = Integer.parseInt(command.get(1));
                    boolean isSuchNumber = false;
                    for (int element : numList) {
                        if (num == element) {
                            isSuchNumber = true;
                        }
                    }
                        if (isSuchNumber) {
                            System.out.println("Yes");
                        } else {
                            System.out.println("No such number");
                        }
                    break;
                case "Print":
                    if (command.get(1).equals("even")) {
                        for (int element : numList) {
                            if (element % 2 == 0) {
                                System.out.print(element + " ");
                            }
                        }
                    } else if (command.get(1).equals("odd")) {
                        for (int element : numList) {
                            if (element % 2 != 0) {
                                System.out.print(element + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (int element : numList) {
                        sum += element;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = command.get(1);
                    num = Integer.parseInt(command.get(2));
                    printNumbersWithCondition(condition, num, numList);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    public static void printNumbersWithCondition(String condition, int num, List<Integer> numList) {
        if (condition.equals("<")) {
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) < num) {
                    System.out.print(numList.get(i) + " ");
                }
            }
            System.out.println();
        } else if (condition.equals(">")) {
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) > num) {
                    System.out.print(numList.get(i) + " ");
                }
            }
            System.out.println();
        } else if (condition.equals(">=")) {
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) >= num) {
                    System.out.print(numList.get(i) + " ");
                }
            }
            System.out.println();
        }   else if (condition.equals("<=")) {
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) <= num) {
                    System.out.print(numList.get(i) + " ");
                }
            }
        }
    }
}
