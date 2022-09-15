package June2019;

import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        int duration = Integer.parseInt(scanner.nextLine());

        double totalDuration = (episodes * (duration * 1.2) + 10) * seasons;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", title, totalDuration);
    }
}
