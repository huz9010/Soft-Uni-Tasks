import java.util.Scanner;

public class Speed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double s = Double.parseDouble(scanner.nextLine()); //speed

        //При скорост до 10 (включително), отпечатайте "slow".
        //•  При скорост над 10 и до 50, отпечатайте "average".
        //•  При скорост над 50 и до 150, отпечатайте "fast".
        //•  При скорост над 150 и до 1000, отпечатайте "ultra fast".
        //•  При по-висока скорост, отпечатайте "extremely fast".

        if (s <= 10){
            System.out.println("slow");
        } else if (s > 10 && s <= 50) {
            System.out.println("average");
        } else if (s > 50 && s <= 150) {
            System.out.println("fast");
        } else if (s > 150 && s <= 1000) {
            System.out.println("ultra fast");
        } else if (s > 1000) {
            System.out.println("extremely fast");
        }
    }
}
