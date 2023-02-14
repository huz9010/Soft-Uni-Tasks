import java.util.Arrays;
import java.util.Scanner;

public class HappyThreeFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] wines = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (canSplit(wines)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean canSplit(int[] arr) {

        int sum = 0;
        for (int e : arr) {
            sum += e;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int equalSum = sum / 3;
        int parts = 0;
        boolean isFound = false;

        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            if (sum == equalSum)    {
                parts++;
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (k != i) {
                        sum += arr[k];
                        if (sum > equalSum) {
                            sum -= arr[k];
                        }
                    }
                    if (sum == equalSum)    {
                        parts++;
                        isFound = true;
                        break;
                    }
                }
                if (isFound)    {
                    isFound = false;
                    break;
                }
            }
        }
        return parts == 3;
    }
}
