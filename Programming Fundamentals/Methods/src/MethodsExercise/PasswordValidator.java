package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean validLength = passwordCharacterLength(input);
        boolean validCharacterType = passwordCharacterType(input);
        boolean validDigitCount = passwordDigitCount(input);

        if (validLength && validCharacterType && validDigitCount){
            System.out.println("Password is valid");
        }
    }

    public static boolean passwordCharacterLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    public static boolean passwordCharacterType(String password) {
        char[] pass = password.toCharArray();
        int counter = 0;
        for (int i = 0; i < pass.length; i++) {
            if (!Character.isLetterOrDigit(pass[i])) {
                counter++;
            }
        }
        if (counter == 0) {
            return true;
        } else {
            System.out.println("Password must consist only of letters and digits");
            return false;
        }
    }

    public static boolean passwordDigitCount(String password){
        char[] pass = password.toCharArray();
        int digitCount = 0;
        for (int i = 0; i < pass.length; i++) {
            if (Character.isDigit(pass[i])){
                digitCount++;
            }
        }
        if (digitCount >= 2){
            return true;
        }   else {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
    }
}
