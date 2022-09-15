import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();

        if (age < 16){
            if (gender.equals("m")) {
                System.out.println("Master");
            } else if (gender.equals("f")) {
                System.out.printf("Miss");
            }
        }

        else if (age >= 16){
            if (gender.equals("m")) {
                System.out.printf("Mr.");
            } else if (gender.equals("f")) {
                System.out.printf("Ms.");

            }
        }
    }
}
