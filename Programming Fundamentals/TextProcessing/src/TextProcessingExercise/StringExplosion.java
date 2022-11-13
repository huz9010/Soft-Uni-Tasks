package TextProcessingExercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int explosionPower = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>')  {
                explosionPower += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            }   else if (explosionPower > 0)    {
                input.deleteCharAt(i);
                explosionPower--;
                i--;
            }
        }
        System.out.println(input);
    }
}
