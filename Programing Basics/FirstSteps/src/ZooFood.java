import java.util.Scanner;

public class ZooFood {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dogfood = Integer.parseInt(scanner.nextLine());
        int catfood = Integer.parseInt(scanner.nextLine());

        double result = (dogfood*2.5)+(catfood*4);

        System.out.println(result + " lv.");
    }
}
