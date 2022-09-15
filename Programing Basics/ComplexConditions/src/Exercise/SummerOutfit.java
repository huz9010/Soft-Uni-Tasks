package Exercise;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int deg = Integer.parseInt(scanner.nextLine());
        String daytime = scanner.nextLine().toLowerCase();

        String outfit = "";
        String shoes = "";

        if (deg >= 10 && deg <= 18){
            if (daytime.equals("morning")){
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (daytime.equals("afternoon")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (daytime.equals("evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else if (deg > 18 && deg <= 24) {
            if (daytime.equals("morning")){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (daytime.equals("afternoon")) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (daytime.equals("evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        } else if (deg >= 25) {
            if (daytime.equals("morning")){
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (daytime.equals("afternoon")) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            } else if (daytime.equals("evening")) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", deg, outfit, shoes);
    }
}
