package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] initialIndexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] initialField = new int[fieldSize];

        for (int element : initialIndexes) {
            if (element >= 0 && element < initialField.length) {
                initialField[element] = 1;
            }
        }
        String input = scanner.nextLine();
         while (!input.equals("end"))   {
             int index = Integer.parseInt(input.split(" ")[0]);
             int targetIndex = Integer.parseInt(input.split(" ")[2]);
             String command = input.split(" ")[1];

             if (targetIndex == 0)  {
                 input = scanner.nextLine();
                 continue;
             }

             if (targetIndex < 0 && command.equals("right")) {
                 command = "left";
                 targetIndex = Math.abs(targetIndex);
             }
                 if (targetIndex < 0 && command.equals("left")) {
                     command = "right";
                     targetIndex = Math.abs(targetIndex);
             }

             if (index >= 0 && index < initialField.length && initialField[index] == 1) {
             switch (command)   {
                 case "right":
                         for (int i = index + targetIndex; i < initialField.length; i += targetIndex) {
                             if (initialField[i] == 0) {
                                 initialField[i] = 1;
                                 break;
                             }
                         }
                             initialField[index] = 0;
                     break;
                 case "left":
                         for (int i = index - targetIndex; i >= 0; i -= targetIndex) {
                             if (initialField[i] == 0) {
                                 initialField[i] = 1;
                                 break;
                             }
                         }
                         initialField[index] = 0;
                     break;
                     }
             }
             input = scanner.nextLine();
         }
        for (int element : initialField)    {
            System.out.print(element + " ");
        }
    }
}
