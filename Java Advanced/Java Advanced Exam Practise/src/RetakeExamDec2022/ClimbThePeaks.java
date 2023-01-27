package RetakeExamDec2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> dailyFood = new ArrayDeque<>();
        ArrayDeque<Integer> dailyStamina = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).forEach(e -> dailyFood.push(Integer.valueOf(e)));
        Arrays.stream(scanner.nextLine().split(", ")).forEach(e -> dailyStamina.offer(Integer.valueOf(e)));

        ArrayDeque<String> peaks = new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");

        ArrayDeque<Integer> peaksDifficulties = new ArrayDeque<>();
        peaksDifficulties.offer(80);
        peaksDifficulties.offer(90);
        peaksDifficulties.offer(100);
        peaksDifficulties.offer(60);
        peaksDifficulties.offer(70);

        ArrayDeque<String>  conqueredPeaks = new ArrayDeque<>();
        boolean isSuccessful = false;

        for (int i = 0; i < 7; i++) {
            int dailyFoodAndStamina = dailyFood.pop() + dailyStamina.poll();
            String currentPeak = peaks.peek();
            int peakDifficulty = peaksDifficulties.peek();
            if (dailyFoodAndStamina >= peakDifficulty)    {
                conqueredPeaks.offer(currentPeak);
                peaks.poll();
                peaksDifficulties.poll();
            }
            if (peaks.isEmpty())    {
                isSuccessful = true;
                break;
            }
        }
        if (isSuccessful) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty())  {
            System.out.println("Conquered peaks:");
            while (!conqueredPeaks.isEmpty())   {
                System.out.println(conqueredPeaks.poll());
            }
        }
    }
}
