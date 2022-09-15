package March2019;

import java.util.Scanner;

public class GameNumberWars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String player1 = scanner.nextLine();
        String player2 = scanner.nextLine();
        String input = scanner.nextLine();
        int player1Points = 0;
        int player2Points = 0;

        while (!input.equals("End of game")) {

            int card1 = Integer.parseInt(input);
            int card2 = Integer.parseInt(scanner.nextLine());

            if (card1 == card2) {
                System.out.println("Number wars!");
                card1 = Integer.parseInt(scanner.nextLine());
                card2 = Integer.parseInt(scanner.nextLine());
                if (card1 > card2) {
                    System.out.printf("%s is winner with %d points", player1, player1Points);
                } else {
                    System.out.printf("%s is winner with %d points", player2, player2Points);
                }
                break;
            }
            if (card1 > card2) {
                player1Points = player1Points + (card1 - card2);
            } else {
                player2Points = player2Points + (card2 - card1);
            }
            input = scanner.nextLine();
        }

            if (input.equals("End of game")) {
                System.out.printf("%s has %d points%n" +
                        "%s has %d points", player1, player1Points, player2, player2Points);
            }
        }
    }
