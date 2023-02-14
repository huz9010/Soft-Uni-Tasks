import java.util.Scanner;

public class CoffeeCups {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine().toUpperCase();

        printSmoke(n);
        printHandle(n, text);
        printCup(n);
        printHolder(n);
    }

    private static void printSmoke(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, n - 1)));
        sb.append(" ~".repeat(3));

        for (int i = 0; i < n; i++) {
            System.out.println(sb);
        }
    }

    private static void printHandle(int n, String text) {
        int width = 3 * n + 6;

        StringBuilder sb = new StringBuilder();

        sb.append("=".repeat(width - 1));

        StringBuilder lines = new StringBuilder();
        lines.append("|").append("~".repeat(2 * n + 4)).append("|").append(" ".repeat(n - 1)).append("|");

        StringBuilder specialLine = new StringBuilder();
        specialLine.append("|").append("~".repeat(n)).append(text).append("~".repeat(n)).append("|")
                .append(" ".repeat(n - 1)).append("|");

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                System.out.println(sb);
            } else if (i == n / 2) {
                System.out.println(specialLine);
            }   else {
                System.out.println(lines);
            }
        }
    }

    private static void printCup(int n) {
        int width = 3 * n + 5;
        int start = 1;
        int end = width - n;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(start - 1));
            sb.append("\\");
            start++;
            sb.append("@".repeat(Math.max(0, end - start + 1)));
            sb.append("/").append(System.lineSeparator());
            end--;
        }
        System.out.print(sb);
    }

    private static void printHolder(int n) {
        System.out.println("-".repeat(3 * n + 5));
    }
}
