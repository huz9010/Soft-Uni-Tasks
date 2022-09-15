package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> bomb = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int bombNum = bomb.get(0);
        int bombPower = bomb.get(1);

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == bombNum)  {
                if ((i - bombPower) < 0 && (i + bombPower) < numList.size())    {
                    numList.subList(0, i + bombPower + 1).clear();
                }   else if ((i - bombPower) >= 0 && (i + bombPower) > numList.size()) {
                    numList.subList(i - bombPower, numList.size()).clear();
                }   else if ((i - bombPower) < 0 && (i + bombPower) >= numList.size())  {
                    numList.subList(0, numList.size()).clear();
                }   else {
                    List<Integer> temp  = numList.subList(i - bombPower, i + bombPower + 1);
                    numList.subList(i - bombPower, i + bombPower + 1).clear();
                }
                i = 0;
            }
        }
        int sum = 0;
        for (int element : numList) {
            sum += element;
        }
        System.out.println(sum);
    }
}
