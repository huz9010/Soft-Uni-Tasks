package July2020;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int fourthStart = start % 10;
        start = start / 10;
        int thirdStart = start % 10;
        start = start / 10;
        int secondStart = start % 10;
        start = start / 10;
        int firstStart = start % 10;

        int fourthEnd = end % 10;
        end = end / 10;
        int thirdEnd = end % 10;
        end = end / 10;
        int secondEnd = end % 10;
        end = end / 10;
        int firstEnd = end % 10;

        for (int i = firstStart; i <= firstEnd; i++) {

            for (int j = secondStart; j <= secondEnd; j++) {

                for (int k = thirdStart; k <=thirdEnd ; k++) {

                    for (int l = fourthStart; l <= fourthEnd; l++) {

                        if ((i % 2 !=0) && (j % 2 !=0) && (k % 2 !=0) && (l % 2 !=0)) {
                            System.out.printf("%d%d%d%d ",i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
