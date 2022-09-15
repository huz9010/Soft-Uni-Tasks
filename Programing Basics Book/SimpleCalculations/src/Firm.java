import com.sun.jdi.IncompatibleThreadStateException;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int neededHours = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double wokringDays = days - days * 0.1;
        double workingHours = Math.floor(wokringDays * 8 * workers + wokringDays * 2 * workers);

        if (workingHours >= neededHours){
            System.out.printf("Yes!%.0f hours left. %n", Math.floor(workingHours - neededHours));
        } else {
            System.out.printf("Not enough time!%.0f hours needed. %n", Math.floor(neededHours - workingHours));
        }
    }
}
