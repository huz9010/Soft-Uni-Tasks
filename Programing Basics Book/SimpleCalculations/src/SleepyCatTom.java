import java.util.Scanner;

public class SleepyCatTom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());
        int workdays = 365 - holidays;

        int playtime = workdays * 63 + holidays * 127;
        double norm = Math.abs(30000 - playtime);

        double normH = Math.floor(norm / 60);
        double normM = Math.floor(norm % 60);

        if (playtime > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%.0f hours and %.0f minutes more for play", normH, normM);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%.0f hours and %.0f minutes less for play", normH, normM);
        }
    }
}