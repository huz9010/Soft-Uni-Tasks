import java.util.*;

public class BiggestFormedNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        StringBuilder sb = new StringBuilder();

        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String firstNum, String secondNum) {
                String first = firstNum + secondNum;
                String second = secondNum + first;
                return second.compareTo(first);
            }
        });

        if (numbers[0].equals("0")) {
            sb.append("0");
        }   else {
            for (String num : numbers)  {
                sb.append(num);
            }
        }
        System.out.println(sb);
    }
}
