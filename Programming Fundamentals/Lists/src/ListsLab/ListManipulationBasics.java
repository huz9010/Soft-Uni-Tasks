package ListsLab;

import com.sun.jdi.IntegerValue;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end"))    {
            List<String> command = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            switch (command.get(0)) {
                case "Add":
                    int num = Integer.parseInt(command.get(1));
                    numList.add(num);
                    break;
                case "Remove":
                    num = Integer.parseInt(command.get(1));
                    numList.remove(Integer.valueOf(num));
                    break;
                case "RemoveAt":
                    num = Integer.parseInt(command.get(1));
                    numList.remove(num);
                    break;
                case "Insert":
                    num = Integer.parseInt(command.get(1));
                    int index = Integer.parseInt(command.get(2));
                    numList.add(index, num);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int element : numList) {
            System.out.print(element + " ");
        }
    }
}
