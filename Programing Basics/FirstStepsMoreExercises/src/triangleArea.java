import java.rmi.UnexpectedException;
import java.util.Scanner;

public class triangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double area = a * h/2;

        System.out.println(String.format("%.2f", area));
    }

}
