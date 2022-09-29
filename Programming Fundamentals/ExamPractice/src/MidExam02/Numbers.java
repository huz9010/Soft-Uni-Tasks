package MidExam02;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        for (Integer element : numList) {
            sum += element;
        }
        double average = sum * 1.0 / numList.size();

        List<Integer> topElements = new ArrayList<>();
        for (Integer element : numList) {
            if (element > average) {
                topElements.add(element);
            }
        }
        Collections.sort(topElements);
        Collections.reverse(topElements);

        if (topElements.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(topElements.get(i) + " ");
            }
        } else if (topElements.size() == 0) {
            System.out.println("No");
        } else {
            for (int element : topElements) {
                System.out.print(element + " ");
            }
        }
    }
}
