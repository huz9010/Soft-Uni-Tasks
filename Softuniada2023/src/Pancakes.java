import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Pancakes {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;
        int startMax = 0;
        int endMax = 0;
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < numbers.length; i++) {
            currentMax += numbers[i];

            if (maxSum < currentMax) {
                maxSum = currentMax;
                startMax = start;
                endMax = i;
                maxLength = endMax - startMax;
            }

            if (maxSum == currentMax && maxLength < i - start) {
                startMax = start;
                endMax = i;
            }

            if (currentMax < 0) {
                currentMax = 0;
                start = i + 1;
            }
        }
        System.out.printf("%d %d %d", maxSum, startMax, endMax);
    }
}
