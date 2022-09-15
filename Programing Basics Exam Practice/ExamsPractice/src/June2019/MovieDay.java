package June2019;

import java.util.Scanner;

public class MovieDay {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int timeForAction = Integer.parseInt(scanner.nextLine());
        int scenes = Integer.parseInt(scanner.nextLine());
        int sceneDuration = Integer.parseInt(scanner.nextLine());

        double preparationTime = timeForAction * 0.15;
        double timeNeeded = sceneDuration * scenes + preparationTime;

        if (timeNeeded > timeForAction) {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", Math.floor(timeNeeded) - timeForAction);
        }   else {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", timeForAction - Math.floor(timeNeeded));
        }
    }
}
