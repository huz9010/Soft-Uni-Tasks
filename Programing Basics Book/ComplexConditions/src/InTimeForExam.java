import java.util.Scanner;

public class InTimeForExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMin = Integer.parseInt(scanner.nextLine());

        String onTime = "On time";
        String late = "Late";
        String early = "Early";

        int examTime = examHour * 60 + examMin;
        int arrivalTime = arrivalHour * 60 + arrivalMin;
        int totalMinutesDifference = arrivalTime - examTime;

        String studentArrival = late;

        if (totalMinutesDifference < -30) {
            studentArrival = early;
        } else if (totalMinutesDifference <= 0) {
            studentArrival = onTime;
        }
        String result = "";

        if (totalMinutesDifference != 0) {
            int hoursDifference = Math.abs(totalMinutesDifference / 60);
            int minutesDifference = Math.abs(totalMinutesDifference % 60);

            if (hoursDifference > 0) {
                result = String.format("%d:%02d hours", hoursDifference, minutesDifference);
            } else {
                result = minutesDifference + " minutes";
            }
            if (totalMinutesDifference < 0) {
                result += " before the start";
            } else {
                result += " after the start";
            }
        }
        System.out.println(studentArrival);
        if (!result.isEmpty()){
            System.out.println(result);
        }
    }
}
