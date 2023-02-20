package point_in_rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle = new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Point point = new Point(scanner.nextInt(), scanner.nextInt());
            scanner.nextLine();
            System.out.println(rectangle.contains(point));
        }
    }
}
