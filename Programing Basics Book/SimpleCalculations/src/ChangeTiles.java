import java.util.Scanner;

public class ChangeTiles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       int square = Integer.parseInt(scanner.nextLine());
        double tileW = Double.parseDouble(scanner.nextLine());
        double tileL = Double.parseDouble(scanner.nextLine());
        int benchW = Integer.parseInt(scanner.nextLine());
        int benchL = Integer.parseInt(scanner.next());
        double tileTime = 0.2;

        int area = square*square;
        double tileArea = tileL*tileW;
        int benchArea = benchL*benchW;

        int repairArea = area - benchArea;
        double tiles = repairArea / tileArea;

        double time = tiles * tileTime;

        System.out.println(tiles);
        System.out.println(time);

    }
}
