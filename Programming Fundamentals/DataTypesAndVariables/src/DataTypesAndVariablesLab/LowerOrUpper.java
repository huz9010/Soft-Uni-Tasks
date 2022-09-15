package DataTypesAndVariablesLab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char character = scanner.nextLine().charAt(0);

        if (Character.isLowerCase(character))   {
            System.out.println("lower-case");
        } else if (Character.isUpperCase(character)) {
            System.out.println("upper-case");
        }
    }
}
