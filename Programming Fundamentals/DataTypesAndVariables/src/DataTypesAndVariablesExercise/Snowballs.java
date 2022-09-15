package DataTypesAndVariablesExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte snowballs = Byte.parseByte(scanner.nextLine());
        long highestValue = 0;
        short highestSnow = 0;
        short highestTime = 0;
        byte highestQuality = 0;

        for (int i = 1; i <= snowballs; i++) {
            short snowballSnow = Short.parseShort(scanner.nextLine());
            short snowballTime = Short.parseShort(scanner.nextLine());
            byte snowballQuality = Byte.parseByte(scanner.nextLine());

            long snowballValue = (long) Math.pow ((snowballSnow / snowballTime), snowballQuality);

            if (snowballValue > highestValue)   {
                highestValue = snowballValue;
                highestSnow = snowballSnow;
                highestTime = snowballTime;
                highestQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", highestSnow, highestTime, highestValue, highestQuality);
    }
}
