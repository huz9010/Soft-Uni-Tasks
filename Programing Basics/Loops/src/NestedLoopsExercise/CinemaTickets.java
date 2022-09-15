package NestedLoopsExercise;

import com.sun.jdi.DoubleValue;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int allTickets = 0;
        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;

        while (!movie.equals("Finish")) {

            int places = Integer.parseInt(scanner.nextLine());
            String ticketType = scanner.nextLine();
            int movieTotal = 0;

            while (!ticketType.equals("End"))   {
                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        allTickets++;
                        movieTotal++;
                    break;
                    case "standard":
                        standardTickets++;
                        allTickets++;
                        movieTotal++;
                        break;
                    case "kid":
                        kidTickets++;
                        allTickets++;
                        movieTotal++;
                        break;
                }
                if (movieTotal >= places)    {
                    break;
                }
                ticketType = scanner.nextLine();


            }
            double percentageFull = (movieTotal * 1.0 / places * 100);
            System.out.printf("%s - %.2f%% full.",movie, percentageFull);
            System.out.println();
            movie = scanner.nextLine();

        }

        double studentPer = (studentTickets * 1.0 / allTickets) * 100;
        double standardPer = (standardTickets * 1.0 / allTickets) * 100;
        double kidPer = (kidTickets * 1.0 / allTickets) * 100;

        System.out.printf("Total tickets: %d%n", allTickets);
        System.out.printf("%.2f%% student tickets.%n", studentPer);
        System.out.printf("%.2f%% standard tickets.%n", standardPer);
        System.out.printf("%.2f%% kids tickets.", kidPer);

    }
}
