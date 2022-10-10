package AssociativeArraysLab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> numMap = new TreeMap<>();

        for (Double num : nums) {
            if (!numMap.containsKey(num))   {
                numMap.put(num, 0);
            }
            numMap.put(num, numMap.get(num) + 1);
        }
        for (Map.Entry<Double, Integer> entry : numMap.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}