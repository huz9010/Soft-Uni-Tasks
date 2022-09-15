import java.util.Scanner;

public class vacationBookList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pageCount = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int daysNeeded = Integer.parseInt(scanner.nextLine());

        int readingHours = pageCount/pagesPerHour;
        int hoursPerDay = readingHours/daysNeeded;

        System.out.println(hoursPerDay);
    }
}
