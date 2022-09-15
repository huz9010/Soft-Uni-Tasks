package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double result = mathPower(num, power);
        DecimalFormat df = new DecimalFormat("0.####");

        System.out.printf(df.format(result));
    }

    public static Double mathPower(double num, int pow)   {
        double result = 1;
        for (int i = 1; i <= pow; i++) {
            result *= num;
        }
        return result;
    }
}
