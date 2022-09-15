package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();
        double bill = 0;

        switch (day)    {
            case "Friday":
                if (groupType.equals("Students"))   {
                    if (people >= 30)   {
                        bill = people * 8.45 * 0.85;
                    } else {
                        bill = people * 8.45;
                    }
                }
                if (groupType.equals("Business"))   {
                    if (people >= 100)   {
                        bill = (people - 10) * 10.90;
                    } else {
                        bill = people * 10.90;
                    }
                }
                if (groupType.equals("Regular"))   {
                if (people >= 10 && people <= 20)   {
                    bill = people * 15 * 0.95;
                } else {
                    bill = people * 15;
                }
            }
                break;

            case "Saturday":
                if (groupType.equals("Students"))   {
                    if (people >= 30)   {
                        bill = people * 9.80 * 0.85;
                    } else {
                        bill = people * 9.80;
                    }
                }
                if (groupType.equals("Business"))   {
                    if (people >= 100)   {
                        bill = (people - 10) * 15.60;
                    } else {
                        bill = people * 15.60;
                    }
                }
                if (groupType.equals("Regular"))   {
                    if (people >= 10 && people <= 20)   {
                        bill = people * 20 * 0.95;
                    } else {
                        bill = people * 20;
                    }
                }
                break;

            case "Sunday":
                if (groupType.equals("Students"))   {
                    if (people >= 30)   {
                        bill = people * 10.46 * 0.85;
                    } else {
                        bill = people * 10.46;
                    }
                }
                if (groupType.equals("Business"))   {
                    if (people >= 100)   {
                        bill = (people - 10) * 16;
                    } else {
                        bill = people * 16;
                    }
                }
                if (groupType.equals("Regular"))   {
                    if (people >= 10 && people <= 20)   {
                        bill = people * 22.50 * 0.95;
                    } else {
                        bill = people * 22.50;
                    }
                }
                break;
        }
        System.out.printf("Total price: %.2f", bill);
    }
}
