package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        HashSet<String> filters = new HashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("Print"))  {
            String command = input.split(";")[0];
            String filter = input.split(";")[1];
            String filterValue = input.split(";")[2];

            if (command.equals("Add filter"))  {
                filters.add(filter + ";" + filterValue);
            } else {
                filters.remove(filter + ";" + filterValue);
            }
            input = scanner.nextLine();
        }

        filters.forEach(f -> {
            Predicate<String> filterToApply = getPredicate(f);
            assert filterToApply != null;
            guests.removeIf(filterToApply);
        });

        guests.forEach(e -> System.out.print(e + " "));
    }


    private static Predicate<String> getPredicate(String f) {
        String filterName = f.split(";")[0];
        String filterValue = f.split(";")[1];

        switch (filterName) {
            case "Starts with":
                return s -> s.startsWith(filterValue);
            case "Ends with":
                return s -> s.endsWith(filterValue);
            case "Length":
                return s -> s.length() == Integer.parseInt(filterValue);
            case "Contains":
                return s -> s.contains(filterValue);
        }
        return null;
    }
}
