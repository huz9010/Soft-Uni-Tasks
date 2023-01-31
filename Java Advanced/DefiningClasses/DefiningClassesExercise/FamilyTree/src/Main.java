import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        String input = scanner.nextLine();

        Person primaryPerson = new Person(input);
        List<Person> people = new ArrayList<>();

        input = scanner. nextLine();

        while (!input.equals("End"))    {
            String[] data = input.split(" - ");
            
            if (data.length == 1)   {
                Person person = new Person(data[0]);
            } else if (data.length == 2) {
                if (Character.isDigit(data[0].charAt(0)))   {

                }
            }

            input = scanner.nextLine();
        }

    }
}
