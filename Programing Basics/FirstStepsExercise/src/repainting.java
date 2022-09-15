import java.util.Scanner;

public class repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double nylonPrice = (nylon + 2) * 1.5;
        double paintPrice = (paint + paint * 0.1) * 14.5;
        int thinnerPrice = thinner * 5;
        double bags = 0.4;
        double materialsSum = nylonPrice + paintPrice + thinnerPrice + bags;
        double workersPrice = hours * (materialsSum * 0.3);

        double sum = materialsSum + workersPrice;

        System.out.println(sum);

    }
}
