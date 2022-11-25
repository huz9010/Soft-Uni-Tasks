package FinalExam04;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done"))   {
            String[] inputCommand = input.split("\\s+");
            String command = inputCommand[0];
            StringBuilder newPassword = new StringBuilder();
            switch (command)    {
                case "TakeOdd":

                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            newPassword.append(password.charAt(i));
                        }
                    }
                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(inputCommand[1]);
                    int length = Integer.parseInt(inputCommand[2]);

                    password = newPassword.append(password).delete(index, index + length).toString();
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = inputCommand[1];
                    String substitute = inputCommand[2];

                    if (password.contains(substring))   {
                            password = password.replaceAll(substring, substitute);
                        System.out.println(password);
                    }   else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
