import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());

        while (true)    {
           double a = num * 2;
           if (num < 0) {
               System.out.println("Negative number!");
               break;
           }
            System.out.printf("Result: %.2f%n", a);
           num = Double.parseDouble(scanner.nextLine());
        }
    }
}
