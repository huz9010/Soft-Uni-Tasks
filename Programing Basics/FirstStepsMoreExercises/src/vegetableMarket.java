import java.util.Scanner;

public class vegetableMarket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double vegPrice = Double.parseDouble(scanner.nextLine());
        double fruitPrice = Double.parseDouble(scanner.nextLine());
        double vegkg = Double.parseDouble(scanner.nextLine());
        double fruitkg = Double.parseDouble(scanner.nextLine());

        double income = (vegPrice * vegkg + fruitPrice * fruitkg) / 1.94;

        System.out.println(String.format("%.2f", income));
    }
}
