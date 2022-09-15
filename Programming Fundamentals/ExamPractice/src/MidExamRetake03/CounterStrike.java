package MidExamRetake03;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int battlesWon = 0;
        boolean noEnergy = false;

        while (!input.equals("End of battle")){
            int distance = Integer.parseInt(input);
            if (energy < distance){
                noEnergy = true;
                break;
            }   else {
                energy = energy - distance;
                battlesWon++;
                if (battlesWon % 3 == 0) {
                    energy = energy + battlesWon;
                }
            }
            input = scanner.nextLine();
        }
        if (noEnergy){
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWon, energy);
        }   else {
            System.out.printf("Won battles: %d. Energy left: %d", battlesWon, energy);
        }
    }
}
