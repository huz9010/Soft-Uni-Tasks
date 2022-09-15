import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine().toLowerCase();
        int nights = Integer.parseInt(scanner.nextLine());

        String result = "";

        switch (month){
            case "may":
            case "october":
                if (nights <= 7){
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 65.0), (nights * 50.0));
                } else if (nights <= 14){
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 65.0), (nights * 50.0 - 0.05 * nights * 50.0));
                } else {
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 65.0 - 0.1 * nights * 65.0), (nights * 50.0 - 0.3 * nights * 50.0));
                }
                break;
            case "june":
            case "september":
                if (nights <= 7){
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 68.7), (nights * 75.2));
                } else if (nights <= 14){
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 68.7), (nights * 75.2));
                } else {
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 68.7 - 0.1 * nights * 68.7), (nights * 75.2 - 0.2 * nights * 75.2));
                }
                break;
            case "july":
            case "august":
                if (nights <= 7){
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 77.0), (nights * 76.0));
                } else if (nights <= 14){
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 77.0), (nights * 76.0));
                } else {
                    result = String.format("Apartment: %.2f lv.%nStudio: %.2f lv.", (nights * 77.0 - 0.1 * nights * 77.0), (nights * 76.0));
                }
                break;
        }
        System.out.println(result);
    }
}
