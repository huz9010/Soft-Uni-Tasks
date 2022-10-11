package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> participants = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languages = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("exam finished"))  {
            String[] command = input.split("-");
            String username = command[0];
            String language ="";
            int points = 0;
            if (command[1].equals("banned"))    {
                participants.remove(username);
            }   else {
                language = command[1];
                points = Integer.parseInt(command[2]);

                if (participants.containsKey(username)) {
                    int submissionCount = isNUll(languages.get(language)) + 1;
                    languages.put(language, submissionCount);
                    if (points >= participants.get(username))   {
                        participants.put(username, points);
                    }
                }   else {
                    participants.put(username, points);
                    int submissionCount = isNUll(languages.get(language)) + 1;
                    languages.put(language, submissionCount);
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : participants.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languages.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static Integer isNUll (Integer count)    {
        if (count == null)  {
            return 0;
        }   else {
            return count;
        }
    }
}
