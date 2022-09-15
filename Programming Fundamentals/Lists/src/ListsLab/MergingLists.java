package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        int smallestList = list1.size();
        if (list1.size() > list2.size())    {
            smallestList = list2.size();
        }
        for (int i = 0; i < smallestList; i++) {
            resultList.add(list1.get(i));
            resultList.add(list2.get(i));
        }
        if (list1.size() > list2.size())    {
            resultList.addAll(list1.subList(smallestList, list1.size()));
        }   else if (list2.size() > list1.size())   {
            resultList.addAll(list2.subList(smallestList, list2.size()));
        }
        for (int element : resultList)  {
            System.out.print(element + " ");
        }
    }
}