package June2019;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

                String actorName = scanner.nextLine();
                double academyPoints = Double.parseDouble(scanner.nextLine());
                int juryMembers = Integer.parseInt(scanner.nextLine());
                double totalPoints = 0;

                for (int i = 1; i <= juryMembers; i++) {
                    String judge = scanner.nextLine();
                    double judgePoints = Double.parseDouble(scanner.nextLine());

                    int nameLength = judge.length();
                    double juryPoints = nameLength * judgePoints / 2;
                    totalPoints += juryPoints;

                    if ((totalPoints + academyPoints) > 1250.5) {
                        break;
                    }
                }
                if ((totalPoints + academyPoints) > 1250.5)   {
                    System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoints + academyPoints);
                }   else {
                    System.out.printf("Sorry, %s you need %.1f more!", actorName, (1250.5 - totalPoints - academyPoints));
                }
    }
}



