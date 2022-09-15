package March2019;

import java.util.Scanner;

public class FitnessCenter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int visitors = Integer.parseInt(sc.nextLine());
        int back = 0;
        int chest = 0;
        int legs = 0;
        int abs = 0;
        int proteinShake = 0;
        int proteinBar = 0;
        int workout = 0;
        int protein = 0;

        for (int i = 1; i <= visitors ; i++) {
            String input = sc.nextLine();

            switch (input)  {
                case "Back":
                    back++;
                    workout++;
                    break;

                case "Chest":
                    chest++;
                    workout++;
                    break;

                case "Legs":
                    legs++;
                    workout++;
                    break;

                    case "Abs":
                        abs++;
                        workout++;
                    break;

                    case "Protein shake":
                        proteinShake++;
                        protein++;
                    break;

                    case "Protein bar":
                        proteinBar++;
                        protein++;
                    break;
            }
        }

        double workoutPercent = workout * 1.0 / visitors * 100;
        double proteinPercent = protein * 1.0 / visitors * 100;

        System.out.printf("%d - back%n" +
                "%d - chest%n" +
                "%d - legs%n" +
                "%d - abs%n" +
                "%d - protein shake%n" +
                "%d - protein bar%n" +
                "%.2f%% - work out%n" +
                "%.2f%% - protein", back, chest, legs, abs, proteinShake, proteinBar, workoutPercent, proteinPercent);
    }
}
