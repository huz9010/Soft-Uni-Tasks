package AssociativeArraysMoreExercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contestData = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end of contests"))    {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestData.put(contest, password);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (input.equals("end of submissions"))  {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            String username = input.split(":")[2];
            int points = Integer.parseInt(input.split(":")[3]);

            if (contestData.containsKey(contest) && contestData.containsValue(password))    {

            }
            input = scanner.nextLine();
        }
    }
}
