package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decNum = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binNum = new ArrayDeque<>();

        if (decNum == 0) {
            System.out.print(decNum);
        } else {
            while (decNum > 0) {
                binNum.push(decNum % 2);
                decNum /= 2;
            }
            for (Integer integer : binNum) {
                System.out.print(integer);
            }
        }
    }
}
