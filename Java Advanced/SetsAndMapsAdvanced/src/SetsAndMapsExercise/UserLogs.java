package SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> attacks = new TreeMap<>();

        while (!input.equals("end"))    {
            String ipAddress = input.split("\\s+")[0].split("=")[1];
            String userName = input.split("\\s+")[2].split("=")[1];

            attacks.putIfAbsent(userName, new LinkedHashMap<>());
            attacks.get(userName).putIfAbsent(ipAddress, 0);
            int messageCount = attacks.get(userName).get(ipAddress);
            messageCount++;
            attacks.get(userName).put(ipAddress, messageCount);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> attack : attacks.entrySet()) {
            System.out.println(attack.getKey() + ": ");

            int counter = attack.getValue().size();
            for (Map.Entry<String, Integer> ipAddress : attack.getValue().entrySet()) {
                if (counter > 1) {
                    System.out.print(ipAddress.getKey() + " => " + ipAddress.getValue() + ", ");
                } else {
                    System.out.println(ipAddress.getKey() + " => " + ipAddress.getValue() + ".");
                }
                counter--;
            }
        }
    }
}
