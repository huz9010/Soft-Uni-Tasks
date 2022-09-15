import java.util.Scanner;

public class schoolSupplies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int penPacks = Integer.parseInt(scanner.nextLine());
        int markerPacks = Integer.parseInt(scanner.nextLine());
        int detergentLitres = Integer.parseInt(scanner.nextLine());
        double discountPercent = Double.parseDouble(scanner.nextLine());

        double penPrice = penPacks * 5.80;
        double markerPrice = markerPacks * 7.20;
        double detergentPrice = detergentLitres * 1.20;
        double discount = discountPercent / 100;

        double sum = (penPrice + markerPrice + detergentPrice) - ((penPrice + markerPrice + detergentPrice) * discount);

        System.out.println(sum);
    }
}
