package July2020;

import com.sun.jdi.IntegerValue;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String player = scanner.nextLine();

        String bestPlayer = "";
        int maxGoals = 0;

        while (!player.equals("END"))    {
            int goals = Integer.parseInt(scanner.nextLine());

            if (goals > maxGoals)   {
                maxGoals = goals;
                bestPlayer = player;
            }

                if (maxGoals >= 10){
                    break;
                }
            player = scanner.nextLine();
        }
        if (maxGoals >= 3) {
            System.out.printf("%s is the best player!%n" +
                    "He has scored %d goals and made a hat-trick !!!", bestPlayer, maxGoals);
        }   else {
            System.out.printf("%s is the best player!%n" +
                    "He has scored %d goals.", bestPlayer, maxGoals);
        }
    }
}
