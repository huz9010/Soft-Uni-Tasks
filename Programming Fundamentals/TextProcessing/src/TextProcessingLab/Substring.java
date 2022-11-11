package TextProcessingLab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToRemove = scanner.nextLine();
        String resultString = scanner.nextLine();

        while (resultString.contains(stringToRemove))  {
            if (resultString.contains(stringToRemove))  {
                resultString = resultString.replace(stringToRemove, "");
            }
        }
        System.out.println(resultString);
    }
}
