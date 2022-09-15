package March2019;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                int annualTax = Integer.parseInt(scanner.nextLine());

                double trainersPrice = annualTax - annualTax * 0.4;
                double equipmentPrice =  trainersPrice - trainersPrice * 0.2;
                double ballPrice = equipmentPrice / 4;
                double accessoriesPrice = ballPrice / 5;

                double sum  = annualTax + trainersPrice + equipmentPrice + ballPrice + accessoriesPrice;

                System.out.printf("%.2f",sum);

            }

        }
