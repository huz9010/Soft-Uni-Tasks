package football_team_generator;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Team> teams = new LinkedHashMap();

        String input = scanner.nextLine();

        while (!input.equals("END"))    {
            String[] inputCommand = input.split(";");
            String command = inputCommand[0];
            String teamName = inputCommand[1];

            try {
                switch (command) {
                    case "Team":
                        teams.put(teamName, new Team(teamName));
                        break;
                    case "Add":
                        if (!teams.containsKey(teamName))  {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }   else {
                            String playerName = inputCommand[2];
                            int endurance = Integer.parseInt(inputCommand[3]);
                            int sprint = Integer.parseInt(inputCommand[4]);
                            int dribble = Integer.parseInt(inputCommand[5]);
                            int passing = Integer.parseInt(inputCommand[6]);
                            int shooting = Integer.parseInt(inputCommand[7]);
                            teams.get(teamName).addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
                        }
                        break;
                    case "Remove":
                        if (!teams.containsKey(teamName))   {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }   else {
                            String playerName = inputCommand[2];
                            teams.get(teamName).removePlayer(playerName);
                        }
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName))   {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }   else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid command" + command);
                }
            }   catch (IllegalArgumentException e)  {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
