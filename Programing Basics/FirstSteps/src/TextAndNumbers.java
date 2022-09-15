import java.util.Scanner;

public class TextAndNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You are <firstName> <lastName>, a <age>-years old person from <town>.

        String fn = scanner.nextLine();
        String ln = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String town = scanner.nextLine();

        System.out.printf("You are %s %s, a %d-years old person from %s.", fn, ln, age, town);
    }
}
