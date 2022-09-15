import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double l = Double.parseDouble(scanner.nextLine());
        double w = Double.parseDouble(scanner.nextLine());

        double rows = l / 1.20;
        double cols = (w - 1) / 0.70;

        int introws = (int) rows;
        int intcols = (int) cols;

        int workplaces = introws * intcols - 3;


        System.out.println(workplaces);


    }
}
