package June2019;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int income = 0;
        int totalPeople = 0;
        boolean isFull = false;

        while (!input.equals("Movie time!"))    {
            int people = Integer.parseInt(input);
            int currentIncome = 0;

            totalPeople = totalPeople + people;

            if (totalPeople > capacity) {
                System.out.printf("The cinema is full.%n" +
                        "Cinema income - %d lv.", income);
                isFull = true;
                break;
            }

            if (people % 3 ==0) {
                currentIncome = people * 5 - 5;
            }   else {
                currentIncome = people * 5;
            }
            income = income + currentIncome;


            input = scanner.nextLine();
        }
        if (!isFull)    {
            System.out.printf("There are %d seats left in the cinema.%n" +
                    "Cinema income - %d lv.", (capacity - totalPeople), income);
        }
    }
}
