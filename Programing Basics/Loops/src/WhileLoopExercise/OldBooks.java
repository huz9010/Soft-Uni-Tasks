package WhileLoopExercise;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String theBook = scanner.nextLine();
        int booksChecked = 0;
        String input = scanner.nextLine();
        boolean isFound = false;

        while (!input.equals("No More Books"))  {

            if (input.equals(theBook))  {
               isFound = true;
               break;
            }
            input = scanner.nextLine();
            booksChecked++;
        }
        if (isFound)    {
            System.out.printf("You checked %d books and found it.", booksChecked);
        }   else {
            System.out.printf("The book you search is not here!%n" +
                    "You checked %d books.", booksChecked);
        }
    }
}
