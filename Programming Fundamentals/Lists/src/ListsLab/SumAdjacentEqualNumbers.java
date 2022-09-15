package ListsLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbersList = new java.util.ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList()));

        for (int i = 0; i < numbersList.size() - 1; i++) {
            if (numbersList.get(i).equals(numbersList.get(i + 1)))   {
                double sum = numbersList.get(i) + numbersList.get(i + 1);
                numbersList.set(i, sum);
                numbersList.remove(i + 1);
                i = -1;
            }
        }

        for (double element : numbersList){
            DecimalFormat df = new DecimalFormat("0.#");
            String format = df.format(element);
            System.out.print(format + " ");
        }
    }
}
