package AssociativeArraysExercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> forceBook = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|"))    {
                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];
                boolean isExistingUser = false;

                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    if (entry.getValue().contains(forceUser))   {
                        isExistingUser = true;
                        break;
                    }
                }

                if (isExistingUser) {
                    input = scanner.nextLine();
                    continue;
                }   else if (forceBook.containsKey(forceSide)) {
                    forceBook.get(forceSide).add(forceUser);
                }   else {
                    List<String> users = new ArrayList<>();
                    users.add(forceUser);
                    forceBook.put(forceSide, users);
                }
            }   else {
                String forceUser = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];

                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                        entry.getValue().remove(forceUser);
                }
                if (forceBook.containsKey(forceSide))   {
                    forceBook.get(forceSide).add(forceUser);
                }   else {
                    List<String> users = new ArrayList<>();
                    users.add(forceUser);
                    forceBook.put(forceSide, users);
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
            if (entry.getValue().size() > 0)    {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (String element : entry.getValue()) {
                    System.out.printf("! %s%n", element);
                }
            }
        }
    }
}
