package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> raceTrack = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double leftCarTime = 0;
        double rightCarTime = 0;

        for (int i = 0; i < (raceTrack.size() / 2); i++) {
            if (raceTrack.get(i) == 0)  {
                leftCarTime = leftCarTime * 0.8;
            }
            leftCarTime += raceTrack.get(i);
        }
        for (int i = raceTrack.size() - 1; i > (raceTrack.size() / 2); i--) {
            if (raceTrack.get(i) == 0)  {
                rightCarTime = rightCarTime * 0.8;
            }
            rightCarTime += raceTrack.get(i);
        }

        if (leftCarTime < rightCarTime) {
            System.out.printf("The winner is left with total time: %.1f", leftCarTime);
        }   else {
            System.out.printf("The winner is right with total time: %.1f", rightCarTime);
        }
    }
}
