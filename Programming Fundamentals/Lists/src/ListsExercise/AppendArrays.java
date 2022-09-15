package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(inputList);

        List<Integer> outputList = new ArrayList<>();

        for (String element : inputList) {
            element.replaceAll("\\s+", " ");
        }
        for (String element : inputList) {
            outputList.addAll(Arrays.stream(element.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        for (int element : outputList)  {
            System.out.print(element + " ");
        }
    }
}
