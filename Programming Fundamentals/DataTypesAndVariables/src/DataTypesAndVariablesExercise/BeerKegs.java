package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte kegCount = Byte.parseByte(scanner.nextLine());
        String biggestKeg = "";
        double biggestVol = 0;

        for (int i = 1; i <= kegCount; i++) {
            String kegModel = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = height * Math.pow(radius, 2) * Math.PI;

            if (volume > biggestVol)    {
                biggestVol = volume;
                biggestKeg = kegModel;
            }
        }
        System.out.println(biggestKeg);
    }
}
