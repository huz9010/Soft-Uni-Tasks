package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        List<Integer> numList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).charAt(0) >= 48 && input.get(i).charAt(0) <= 57)   {
                numList.add(Integer.parseInt(input.get(i)));
            }   else {
                stringList.add(input.get(i));
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numList.get(i));
            }   else {
                skipList.add(numList.get(i));
            }
        }
        List<String> output = new ArrayList<>();
        for (int i = 0; i < skipList.size(); i++) {
            int iterations = takeList.get(i);
            for (int j = 0; j < iterations; j++) {
                if (stringList.size() == 0) {
                    break;
                }
                output.add(stringList.get(j));
                stringList.remove(j);
                j -= 1;
                iterations--;
            }
            iterations = skipList.get(i);
            for (int j = 0; j < iterations; j++) {
                if (stringList.size() == 0) {
                    break;
                }
                stringList.remove(j);
                j -= 1;
                iterations--;
            }
        }
        for (String element : output)   {
            System.out.print(element);
        }
    }
}
