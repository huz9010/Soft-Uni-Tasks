package animal_farm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try {
            System.out.println(new Chicken(name, age));
        }   catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
}
