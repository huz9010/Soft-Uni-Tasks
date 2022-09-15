import java.util.Scanner;

public class GrapesAndWine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int square = Integer.parseInt(scanner.nextLine());
        double grapes = Double.parseDouble(scanner.nextLine());
        int neededWine = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double grapesForWine = square * grapes * 0.4;
        double wine = grapesForWine / 2.5;

        if (wine < neededWine){
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(neededWine - wine));
        }   else {
            System.out.printf("Good harvest this year! Total wine: %.0f liters. %n", Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wine - neededWine), Math.ceil((wine - neededWine) / workers));
        }
    }
}
