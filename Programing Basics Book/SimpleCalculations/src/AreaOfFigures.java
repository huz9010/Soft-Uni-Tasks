import java.text.DecimalFormat;
import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fig = scanner.nextLine();
        
        if (fig.equals("square")){
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println(new DecimalFormat("##.###").format(a*a));
        } else if (fig.equals("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            System.out.println(new DecimalFormat("##.###").format(a*b));
        } else if (fig.equals("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            System.out.println(new DecimalFormat("##.###").format(Math.PI*r*r));
        } else if (fig.equals("triangle")) {
            double c = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            System.out.println(new DecimalFormat("##.###").format(c*h/2));
        }
    }
}
