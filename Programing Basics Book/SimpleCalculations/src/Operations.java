import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        String result = "";

        Double calc = 0.0;
        int calcint = 0;

        if (n2 == 0 && (operator.equals("/") || operator.equals("%"))) {
            result = String.format("Cannot divide %d by zero", n1);
            System.out.println(result);
        } else if (operator.equals("/")) {
            calc = (double) n1 / (double) n2;
            result = String.format("%d %s %d = %.2f", n1, operator, n2, calc);
            System.out.println(result);
        } else if (operator.equals("%")) {
            calc = (double) n1 % (double) n2;
            result = String.format("%d %s %d = %.0f", n1, operator, n2, calc);
            System.out.println(result);
        } else {
            switch (operator) {
                case "+":
                    calcint = n1 + n2;
                    result = String.format("%d %s %d = %d", n1, operator, n2, calcint);
                    break;
                case "-":
                    calcint = n1 - n2;
                    result = String.format("%d %s %d = %d", n1, operator, n2, calcint);
                    break;
                case "*":
                    calcint = n1 * n2;
                    result = String.format("%d %s %d = %d", n1, operator, n2, calcint);
                    break;
            }
            String numberIs = "";
            if (calcint % 2 == 0) {
                numberIs = "even";
            } else {
                numberIs = "odd";
            }
            System.out.printf(result + " - " + numberIs);
        }
    }
}
