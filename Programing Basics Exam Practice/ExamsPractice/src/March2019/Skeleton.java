package March2019;

import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int controlMins = Integer.parseInt(scanner.nextLine());
        int controlSecs = Integer.parseInt(scanner.nextLine());
        double trackM = Double.parseDouble(scanner.nextLine());
        int secsFor100 = Integer.parseInt(scanner.nextLine());

        int controlInSecs = controlMins * 60 + controlSecs;
        double minusTime = trackM / 120;
        double time = trackM / 100 * secsFor100 - minusTime * 2.5;

        if (time <= controlInSecs)  {
            System.out.printf("Marin Bangiev won an Olympic quota!%n" +
                    "His time is %.3f.", time);
        }   else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", (time - controlInSecs));
        }
    }
}
