import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String series = scanner.nextLine();
        int episodeDuration = Integer.parseInt(scanner.nextLine());
        int breakDuration = Integer.parseInt(scanner.nextLine());

        double lunchTime = breakDuration / 8.0;
        double restTime = breakDuration / 4.0;

        double timeLeft = breakDuration - lunchTime - restTime;

        if (episodeDuration <= timeLeft){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", series, Math.ceil(timeLeft - episodeDuration));
        }   else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", series, Math.ceil(episodeDuration - timeLeft));
        }
    }
}
