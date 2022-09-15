package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int[] sum = new int[lines];

        for (int i = 0; i < lines; i++) {
            char[] array = scanner.nextLine().toCharArray();
            int result = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 'a' || array[j] == 'e' || array[j] == 'i' || array[j] == 'o' || array[j] == 'u'
                        || array[j] == 'A' || array[j] == 'E' || array[j] == 'I' || array[j] == 'O' || array[j] == 'U') {
                    result += array[j] * array.length;
                } else {
                    result += array[j] / array.length;
                }
            }
            sum[i] += result;
        }
        Arrays.sort(sum);
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }
    }
}
