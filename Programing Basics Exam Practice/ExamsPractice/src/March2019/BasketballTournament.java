package March2019;

import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String tournament = scanner.nextLine();
        int totalMatches = 0;
        int wins = 0;
        int loses = 0;

        while (!tournament.equals("End of tournaments"))    {
            int matchCount = Integer.parseInt(scanner.nextLine());
            totalMatches += matchCount;


            for (int i = 1; i <= matchCount; i++) {
                int desisTeam = Integer.parseInt(scanner.nextLine());
                int otherTeam = Integer.parseInt(scanner.nextLine());

                if (desisTeam > otherTeam)  {
                    wins++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n" ,i, tournament, (desisTeam - otherTeam));
                } else if (otherTeam > desisTeam) {
                    loses++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", i ,tournament, (otherTeam - desisTeam));
                }
            }
            tournament = scanner.nextLine();
        }
        double winsPercent = wins * 1.0 / totalMatches * 100;
        double losesPercent = loses * 1.0 / totalMatches * 100;
        System.out.printf("%.2f%% matches win%n" +
                "%.2f%% matches lost", winsPercent, losesPercent);
    }
}
