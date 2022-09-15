import java.net.Inet4Address;
import java.util.Scanner;

public class aquarium {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lengthCm = Integer.parseInt(scanner.nextLine());
        int widthCm = Integer.parseInt(scanner.nextLine());
        int heightCm = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volumeCm3 = lengthCm * widthCm *heightCm;
        double volumeLitres = volumeCm3 * 0.001;

        double waterNeeded = volumeLitres - volumeLitres*(percent / 100);

        System.out.println(waterNeeded);
    }
}
