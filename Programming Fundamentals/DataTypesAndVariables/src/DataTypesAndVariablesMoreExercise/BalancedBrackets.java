package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int balanced = 0;

        for (int i = 1; i <= lines; i++) {
            String input = scanner.nextLine();

            if (input.equals("("))  {
                balanced ++;

                if (balanced > 1) {
                    break;
                }

            } else if (input.equals(")")) {
                balanced --;
            }
            if (balanced < 0) {
                break;
            }

        }
        if (balanced == 0)  {
            System.out.println("BALANCED");
        }   else {
            System.out.println("UNBALANCED");
        }
    }
}
