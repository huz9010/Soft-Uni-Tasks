import java.util.Scanner;

public class depositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depAmmount = Double.parseDouble(scanner.nextLine());
        int depPeriod = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double sum = depAmmount + depPeriod * ((depAmmount*(percent/100) / 12));

        System.out.println(sum);
    }
}
