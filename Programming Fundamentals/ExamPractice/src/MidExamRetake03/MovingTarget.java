package MidExamRetake03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End"))    {
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "Shoot":
                    int power = Integer.parseInt(command[2]);
                    if (index >= 0 && index < targets.size())  {
                        if (targets.get(index) > power) {
                            targets.set(index, targets.get(index) - power);
                        }   else {
                            targets.remove(index);
                        }
                    }   else {
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(command[2]);
                    if (index >= 0 && index <= targets.size())    {
                        targets.add(index, value);
                    }   else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(command[2]);
                    if ((index - radius) >= 0 && (index + radius) < targets.size()) {
                        targets.removeAll(targets.subList(index - radius, index + radius + 1));
                    }   else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < targets.size() - 1; i++) {
            System.out.print(targets.get(i) + "|");
        }
        System.out.println(targets.get(targets.size() - 1));
    }
}
