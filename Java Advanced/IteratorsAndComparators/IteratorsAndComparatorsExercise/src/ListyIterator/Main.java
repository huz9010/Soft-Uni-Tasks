package ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator strings = new ListyIterator();

        while (!input.equals("END"))    {
            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];

            switch (command)    {
                case "Create":
                    strings.setStrings(Arrays.copyOfRange(inputParts, 1, inputParts.length));
                    break;

                case "Move":
                    System.out.println(strings.move());
                    break;

                case "HasNext":
                    System.out.println(strings.hasNext());
                    break;

                case "Print":
                    try {
                        strings.print();
                    }   catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
