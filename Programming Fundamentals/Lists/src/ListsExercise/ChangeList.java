package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end"))    {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Delete":
                    int num = Integer.parseInt(command[1]);
                    for (int i = 0; i < numList.size(); i++) {
                        if (numList.get(i) == num)  {
                            numList.remove(i);
                            i = -1;
                        }
                    }
                    break;
                case "Insert":
                    num = Integer.parseInt(command[1]);
                    int index = Integer.parseInt(command[2]);
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
