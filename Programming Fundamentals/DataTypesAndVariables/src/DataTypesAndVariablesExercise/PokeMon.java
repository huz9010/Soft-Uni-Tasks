package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        byte exhaustionFactor = Byte.parseByte(scanner.nextLine());
        int pokedTargets = 0;
        int pokePowerLeft = pokePower;

        while (pokePowerLeft >= distance)   {

            if (pokePowerLeft == pokePower / 2) {
                if (exhaustionFactor != 0) {

                    pokePowerLeft = pokePowerLeft / exhaustionFactor;
                }
            }
            if (pokePowerLeft < distance)   {
                break;
            }
            pokePowerLeft = pokePowerLeft - distance;
            pokedTargets++;
        }
        System.out.println(pokePowerLeft);
        System.out.println(pokedTargets);
    }
}
