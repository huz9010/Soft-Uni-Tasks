import java.util.Scanner;

public class sqareArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a = ");
        int a = Integer.parseInt(scanner.nextLine());

        int area = a*a;

        System.out.println("area = " + area);
    }
}
