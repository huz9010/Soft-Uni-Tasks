import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine().toLowerCase();
        String town = scanner.nextLine().toLowerCase();
        double amount = Double.parseDouble(scanner.nextLine());

        if (town.equals("sofia")){
            if (product.equals("coffee")) {
                System.out.println(amount * 0.50);
            } else if (product.equals("water")) {
                System.out.println(amount * 0.80);
            } else if (product.equals("beer")) {
                System.out.println(amount * 1.2);
            } else if (product.equals("sweets")) {
                System.out.println(amount * 1.45);
            } else if (product.equals("peanuts")) {
                System.out.println(amount * 1.6);
            }

        } else if (town.equals("plovdiv")) {
            if (product.equals("coffee")) {
                System.out.println(amount * 0.40);
            } else if (product.equals("water")) {
                System.out.println(amount * 0.70);
            } else if (product.equals("beer")) {
                System.out.println(amount * 1.15);
            } else if (product.equals("sweets")) {
                System.out.println(amount * 1.30);
            } else if (product.equals("peanuts")) {
                System.out.println(amount * 1.5);
            }
        } else if (town.equals("varna")) {
            if (product.equals("coffee")) {
                System.out.println(amount * 0.45);
            } else if (product.equals("water")) {
                System.out.println(amount * 0.70);
            } else if (product.equals("beer")) {
                System.out.println(amount * 1.10);
            } else if (product.equals("sweets")) {
                System.out.println(amount * 1.35);
            } else if (product.equals("peanuts")) {
                System.out.println(amount * 1.55);
            }
        }
    }
}

