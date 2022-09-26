package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        List<Integer> initialSet = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumSet = new ArrayList<>(initialSet);
        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSet.size(); i++) {
                int qualityReduce = drumSet.get(i) - hitPower;
                drumSet.set(i, qualityReduce);
                if (drumSet.get(i) <= 0)    {
                    if (money >= initialSet.get(i) * 3) {
                        money = money - initialSet.get(i) * 3;
                        drumSet.set(i, initialSet.get(i));
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < drumSet.size(); i++) {
            if (drumSet.get(i) <= 0)    {
                drumSet.remove(i);
                i--;
            }
        }
        for (int element : drumSet) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", money);
    }
}
