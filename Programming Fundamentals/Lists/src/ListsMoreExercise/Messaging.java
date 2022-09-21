package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        List<String> output = new ArrayList<>();

        for (int i = 0; i < numList.size(); i++) {
            List<Integer> tempList = Arrays.stream(numList.get(i).split("")).map(Integer::parseInt).collect(Collectors.toList());
            int index = 0;
            for (int j = 0; j < tempList.size(); j++) {
                index += tempList.get(j);
            }
            if (index >= text.size())   {
                index = index % text.size();
            }
            output.add(text.get(index));
            text.remove(index);
        }
        for (String element : output)   {
            System.out.print(element);
        }
    }
}
