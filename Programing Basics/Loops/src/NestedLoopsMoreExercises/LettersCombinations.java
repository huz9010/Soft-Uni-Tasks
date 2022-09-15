package NestedLoopsMoreExercises;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char stop = scanner.nextLine().charAt(0);
        char exclude = scanner.nextLine().charAt(0);
        int count = 0;

        for (int i = start; i <= stop ; i++) {

            char ch1 = 'a';
            char ch2 = 'a';
            char ch3 = 'a';

            if (i == exclude)   {
                continue;
            }   else {
                ch1 = (char) i;
            }

            for (int j = start; j <= stop ; j++) {

                if (j == exclude)   {
                    continue;
                }   else {
                    ch2 = (char) j;
                }

                for (int k = start; k <= stop ; k++) {

                    if (k == exclude)   {
                        continue;
                    }   else {
                        ch3 = (char) k;
                    }
                    System.out.printf("%c%c%c ", ch1, ch2, ch3);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
