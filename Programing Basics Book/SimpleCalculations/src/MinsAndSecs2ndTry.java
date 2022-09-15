import java.util.Scanner;

public class MinsAndSecs2ndTry {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sec1 = Integer.parseInt(scanner.nextLine());
        int sec2 = Integer.parseInt(scanner.nextLine());
        int sec3 = Integer.parseInt(scanner.nextLine());

        int totalTime = sec1 + sec2 + sec3;

        int minutes = totalTime / 60;
        int seconds = totalTime % 60;

        if (seconds < 10){
            System.out.printf("%d:0%d", minutes, seconds);
        }
        else System.out.printf("%d:%d", minutes, seconds);
    }
}
