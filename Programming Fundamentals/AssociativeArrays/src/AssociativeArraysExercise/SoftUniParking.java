package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, String> parkingUsers = new LinkedHashMap<>();

        for (int i = 0; i < commandCount; i++) {
            String[] input = scanner.nextLine().split(" ");
            String user = input[1];
            switch (input[0])   {
                case "register":
                    String plateNum = input[2];
                    if (parkingUsers.containsKey(user)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingUsers.get(user));
                        continue;
                    }   else {
                        parkingUsers.put(user, plateNum);
                        System.out.printf("%s registered %s successfully%n", user, plateNum);
                    }
                    break;
                case "unregister":
                    if (parkingUsers.containsKey(user)) {
                        parkingUsers.remove(user);
                        System.out.printf("%s unregistered successfully%n", user);
                    }   else {
                        System.out.printf("ERROR: user %s not found%n", user);
                        continue;
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> entry : parkingUsers.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
