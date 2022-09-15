import java.util.Scanner;

public class DailyEarnings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int workDays = Integer.parseInt(scanner.nextLine());
        double mPerDay = Double.parseDouble(scanner.nextLine());
        double dollarToBgn = Double.parseDouble(scanner.nextLine());

        double monthlyPayment = workDays * mPerDay;
        double annualSalary = (monthlyPayment * 12) + monthlyPayment * 2.5;
        double taxes = annualSalary * 0.25;

        double yearlyEarns = annualSalary - taxes;
        double dailyEarnsBgn = yearlyEarns / 365 * dollarToBgn;

        System.out.println(String.format("%.2f", dailyEarnsBgn));

    }
}
