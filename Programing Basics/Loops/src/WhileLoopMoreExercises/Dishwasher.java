package WhileLoopMoreExercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int detergent = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int neededDet = 0;
        int counter = 0;
        int dishesWashed = 0;
        int potsWashed = 0;
        int usedDet = 0;

        while (!input.equals("End"))    {

            int dishes = Integer.parseInt(input);
            counter++;

            if (counter % 3 ==0)    {
                potsWashed = potsWashed + dishes;
                usedDet = usedDet + dishes * 15;

            }   else {
                dishesWashed = dishesWashed + dishes;
                usedDet = usedDet + dishes * 5;
            }
            if (usedDet > detergent * 750) {
                break;
            }
            input = scanner.nextLine();
        }
        if (usedDet > detergent * 750)    {
            System.out.printf("Not enough detergent, %d ml. more necessary!", (usedDet - detergent * 750));
        }   else {
            System.out.printf("Detergent was enough!%n" +
                    "%d dishes and %d pots were washed.%n" +
                    "Leftover detergent %d ml.", dishesWashed, potsWashed, (detergent * 750 - usedDet));
        }
    }
}
