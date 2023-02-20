package jediGalaxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Galaxy galaxy = new Galaxy(scanner);
        Player player = new Player();
        EvilPower evilPower = new EvilPower();

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {

            player.setPosition(command);

            command = scanner.nextLine();
            evilPower.setPosition(command);

            evilPower.move(galaxy.getField());
            player.move(galaxy.getField());

            command = scanner.nextLine();
        }

        System.out.println(player.getStarsCollected());
    }
}
