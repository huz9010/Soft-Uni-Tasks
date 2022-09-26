package ArraysExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> chest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!"))    {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Loot":
                    for (int i = 1; i < command.length; i++) {

                        if (!chest.contains(command[i]))    {
                            chest.add(0, command[i]);
                        }

                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(command[1]);
                    if (dropIndex >= 0 && dropIndex < chest.size()) {
                        String temp = chest.get(dropIndex);
                        chest.remove(dropIndex);
                        chest.add(temp);
                    }
                    break;

                case "Steal":
                    int count = Integer.parseInt(command[1]);
                    if (count <= chest.size())  {
                        for (int i = chest.size() - count; i < chest.size() - 1; i++) {
                            System.out.print(chest.get(i) + ", ");

                        }
                        System.out.println(chest.get(chest.size() - 1));
                        for (int i = chest.size() - count; i < chest.size(); i++) {
                            chest.remove(i);
                            i--;
                        }
                    }   else {
                        for (int i = 0; i < chest.size() - 1; i++) {
                            System.out.print(chest.get(i) + ", ");
                        }
                        System.out.println(chest.get(chest.size() - 1));
                        chest.clear();
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        if (chest.size() == 0)  {
            System.out.println("Failed treasure hunt.");
        }   else {
            int sum = 0;
            for (int i = 0; i < chest.size(); i++) {
                sum += chest.get(i).length();
            }
            double gain = sum * 1.0 / chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", gain);
        }
    }
}
