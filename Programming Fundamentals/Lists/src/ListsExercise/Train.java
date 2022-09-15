package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end"))    {
            String[] command = input.split(" ");
            if (command.length == 2)    {
                wagonsList.add(Integer.parseInt(command[1]));
            } else if (command.length == 1) {
                int passengers = Integer.parseInt(command[0]);
                for (int i = 0; i < wagonsList.size(); i++) {
                    if ((wagonsList.get(i) + passengers) <= maxCapacity)    {
                        wagonsList.set(i, wagonsList.get(i) + passengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int element : wagonsList)  {
            System.out.print(element + " ");
        }
    }
}
