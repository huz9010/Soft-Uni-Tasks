package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        String password = "";
        int counter = 1;

        for (int i = user.length() - 1; i >= 0; i--) {
            char currentSym = user.charAt(i);
            password += currentSym;
        }
        while (true)    {
            String pass = scanner.nextLine();

            if (pass.equals(password))    {
                System.out.printf("User %s logged in.", user);
                break;
            } else if (counter == 4) {
                System.out.printf("User %s blocked!", user);
                break;
            }   else {
                System.out.println("Incorrect password. Try again.");
                counter++;
            }
        }
    }
}

