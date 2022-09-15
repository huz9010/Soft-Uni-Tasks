import java.util.Scanner;

public class Architect {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //The architect {името на архитекта} will need {необходими часове} hours to complete {брой на проектите} project/s.

        String name = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());
        int result = projects*3;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, result, projects);
    }
}
