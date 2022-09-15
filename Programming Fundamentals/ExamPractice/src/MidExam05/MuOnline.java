package MidExam05;

import java.util.Arrays;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        boolean madeIt = true;

        for (int i = 0; i < rooms.length; i++) {
            int bestRoom = i + 1;
            String[] currentRoom = rooms[i].split(" ");
            if (currentRoom[0].equals("potion")){
                health += Integer.parseInt(currentRoom[1]);
                if (health <= 100){
                    System.out.printf("You healed for %d hp.%n", Integer.parseInt(currentRoom[1]));
                    System.out.printf("Current health: %d hp.%n", health);
                } else {
                    System.out.printf("You healed for %d hp.%n", (100 - (health - Integer.parseInt(currentRoom[1]))));
                    health = 100;
                    System.out.printf("Current health: %d hp.%n", health);
                }
            } else if (currentRoom[0].equals("chest")) {
                bitcoins += Integer.parseInt(currentRoom[1]);
                System.out.printf("You found %d bitcoins.%n", Integer.parseInt(currentRoom[1]));
            }   else {
                health -= Integer.parseInt(currentRoom[1]);
                if (health <= 0){
                    System.out.printf("You died! Killed by %s.%n", currentRoom[0]);
                    System.out.printf("Best room: %d", bestRoom);
                    madeIt = false;
                    break;
                }   else {
                    System.out.printf("You slayed %s.%n", currentRoom[0]);
                }
            }
        }
        if (madeIt){
            System.out.printf("You've made it!%n" +
                    "Bitcoins: %d%n" +
                    "Health: %d", bitcoins, health);
        }
    }
}
