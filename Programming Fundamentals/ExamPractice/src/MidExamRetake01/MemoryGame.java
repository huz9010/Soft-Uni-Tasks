package MidExamRetake01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        int moves = 1;

        while (!input.equals("end"))    {
            int[] index = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (index[0] == index [1] || index[0] < 0 || index [0] >= sequence.size() || index[1] < 0 || index[1] >= sequence.size()) {
                int tempIndex = sequence.size() / 2;
                sequence.add(tempIndex, "-" + moves + "a");
                sequence.add(tempIndex + 1, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (sequence.get(index[0]).equals(sequence.get(index[1]))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(index[0]));
                    sequence.remove(Math.max(index[0], index[1]));
                    sequence.remove(Math.min(index[0], index[1]));
                } else {
                    System.out.println("Try again!");
                }
            }
            if (sequence.size() == 0)   {
                System.out.printf("You have won in %d turns!%n", moves);
                break;
            }
            moves++;
            input = scanner.nextLine();
        }
        if (sequence.size() > 0)   {
            System.out.printf("Sorry you lose :(%n");
            for (String element : sequence) {
                System.out.print(element + " ");
            }
        }
    }
}
