package SetsAndMapsExercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int logLines = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> userDuration = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userIp = new TreeMap<>();

        for (int i = 0; i < logLines; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String ipAddress = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            userDuration.putIfAbsent(user, 0);
            int time = userDuration.get(user);
            time += duration;
            userDuration.put(user, time);

            userIp.putIfAbsent(user, new TreeSet<>());
            userIp.get(user).add(ipAddress);
        }

        for (Map.Entry<String, Integer> user : userDuration.entrySet()) {
            System.out.printf("%s: %d [", user.getKey(), user.getValue());

            System.out.print(String.join(", ", userIp.get(user.getKey())));
            System.out.println("]");
        }
    }
}
