package NestedLoopsLab;

import java.util.Scanner;

public class SumOfTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magic = Integer.parseInt(scanner.nextLine());

        int combos = 0;
        boolean yes = false;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                combos++;
                int sum = i + j;
                if (sum == magic) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", combos, i, j, magic);
                    yes = true;
                    break;
                }

            }
            if (yes)    {
                break;
            }
        }
        if ((!yes)) {
            System.out.printf("%d combinations - neither equals %d", combos, magic);
        }
    }
}