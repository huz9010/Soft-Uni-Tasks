package ListsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numList2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int length = 0;
        int rangeStart = 0;
        int rangeEnd = 0;

        List<Integer> outputList = new ArrayList<>();
        if (numList1.size() < numList2.size()) {
            for (int i = 0; i < numList1.size(); i++) {
                outputList.add(numList1.get(i));
                numList1.remove(i);
                outputList.add(numList2.get(numList2.size() - 1));
                numList2.remove(numList2.size() - 1);
                i -= 1;
            }
        }   else {
            for (int i = 0; i < numList2.size(); i++) {
                outputList.add(numList1.get(i));
                numList1.remove(i);
                outputList.add(numList2.get(numList2.size() - 1));
                numList2.remove(numList2.size() - 1);
                i -= 1;
            }
        }
        if (numList1.size() == 2)   {
            rangeStart = Math.min(numList1.get(0), numList1.get(1));
            rangeEnd = Math.max(numList1.get(0), numList1.get(1));
        }   else {
            rangeStart = Math.min(numList2.get(0), numList2.get(1));
            rangeEnd = Math.max(numList2.get(0), numList2.get(1));
        }
        Collections.sort(outputList);
        for (Integer element : outputList) {
            if (element > rangeStart && element < rangeEnd) {
                System.out.print(element + " ");
            }
        }
    }
}
