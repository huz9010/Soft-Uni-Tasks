import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String projectionType = scanner.nextLine().toLowerCase();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        int seats = rows * columns;
        double income = 0;

        switch (projectionType) {
            case "premiere":
                income = seats * 12;
                break;
            case "normal":
                income = seats * 7.5;
                break;
            case "discount":
                income = seats * 5;
                break;
        }
        System.out.printf("%.2f leva", income);
    }
}
