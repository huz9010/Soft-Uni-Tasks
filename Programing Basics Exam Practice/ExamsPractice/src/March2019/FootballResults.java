package March2019;

import java.util.Scanner;

public class FootballResults {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wins = 0;
        int loses = 0;
        int draws = 0;

        for (int i = 1; i <= 3; i++) {
            String result = scanner.nextLine();

            int team1 = Integer.parseInt(String.valueOf(result.charAt(0)));
            int team2 = Integer.parseInt(String.valueOf(result.charAt(2)));
            
            if (team1 > team2)  {
                wins++;
            } else if (team1 < team2) {
                loses++;
            }   else {
                draws++;
            }
        }
        System.out.printf("Team won %d games.%n" +
                "Team lost %d games.%n" +
                "Drawn games: %d", wins, loses, draws);
    }
}
