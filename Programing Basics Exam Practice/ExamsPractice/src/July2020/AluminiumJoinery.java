package July2020;

import java.util.Scanner;

public class AluminiumJoinery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String delivery = scanner.nextLine();

        double totalPrice = 0;

        switch (type)   {
            case "90X130":
                if (count <= 30)    {
                    totalPrice = count * 110;
                } else if (count > 60) {
                    totalPrice = count * 110 * 0.92;
                }   else {
                    totalPrice = count * 110 * 0.95;
                }
                break;

            case "100X150":
                if (count <= 40)    {
                    totalPrice = count * 140;
                } else if (count > 80) {
                    totalPrice = count * 140 * 0.9;
                }   else {
                    totalPrice = count * 140 * 0.94;
                }
                break;

            case "130X180":
                if (count <= 20)    {
                    totalPrice = count * 190;
                } else if (count > 50) {
                    totalPrice = count * 190 * 0.88;
                }   else {
                    totalPrice = count * 190 * 0.93;
                }
                break;

            case "200X300":
                if (count <= 25)    {
                    totalPrice = count * 250;
                } else if (count > 50) {
                    totalPrice = count * 250 * 0.86;
                }   else {
                    totalPrice = count * 250 * 0.91;
                }
                break;
        }

        switch (delivery)   {
            case "With delivery":
                if (count > 99) {
                    totalPrice = (totalPrice + 60) * 0.96;
                }   else {
                    totalPrice = totalPrice + 60;
                }
                break;

            case "Without delivery":
                if (count > 99) {
                    totalPrice = totalPrice  * 0.96;
                }
                break;
        }
        if (count < 10) {
            System.out.println("Invalid order");
        }   else {
            System.out.printf("%.2f BGN", totalPrice);
        }

    }
}

