package March2019;

import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String tool = scanner.nextLine();
        double points = 0;
        double diff = 0;

        switch (country)    {
            case "Russia":
                if (tool.equals("ribbon")){
                    points = 9.1 + 9.4;
                    diff = ((20 - points) / 20) * 100;
                } else if (tool.equals("hoop")) {
                    points = 9.3 + 9.8;
                    diff = ((20 - points) / 20) * 100;
                }   else {
                    points = 9.6 + 9;
                    diff = ((20 - points) / 20) * 100;
                }
                break;

            case "Bulgaria":
                if (tool.equals("ribbon")){
                    points = 9.6 + 9.4;
                    diff = ((20 - points) / 20) * 100;
                } else if (tool.equals("hoop")) {
                    points = 9.55 + 9.75;
                    diff = ((20 - points) / 20) * 100;
                }   else {
                    points = 9.5 + 9.4;
                    diff = ((20 - points) / 20) * 100;
                }
                break;

            case "Italy":
                if (tool.equals("ribbon")){
                    points = 9.2 + 9.5;
                    diff = ((20 - points) / 20) * 100;
                } else if (tool.equals("hoop")) {
                    points = 9.45 + 9.35;
                    diff = ((20 - points) / 20) * 100;
                }   else {
                    points = 9.7 + 9.15;
                    diff = ((20 - points) / 20) * 100;
                }
                break;
        }
        System.out.printf("The team of %s get %.3f on %s.%n" +
                "%.2f%%", country, points, tool, diff);
    }
}
