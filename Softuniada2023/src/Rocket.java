import java.util.Scanner;

public class Rocket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int width = n + 5;

        printFirstTwoLines(width);
        printRemainingTop(n);
        printMiddlePart(n, width);
        printBottom(n);
    }

    public static void printFirstTwoLines(int width)    {

        int middle = width / 2;
        String sb = "_".repeat(middle) + "^" + "_".repeat(middle) +
                System.lineSeparator() + "_".repeat((width - 3) / 2) +
                "/" + "|" + "\\" + "_".repeat((width - 3) / 2);

        System.out.println(sb);
    }

    public static void printRemainingTop(int n)    {

        int lineCount = n / 2;
        int dotCount = 0;
        StringBuilder sb = new StringBuilder();

        while (lineCount >= 0)    {
            sb.append("_".repeat(lineCount)).append("/").append(".".repeat(dotCount))
                    .append("|".repeat(3)).append(".".repeat(dotCount))
                    .append("\\").append("_".repeat(lineCount)).append(System.lineSeparator());
            lineCount--;
            dotCount++;
        }
        dotCount-= 2;
        sb.append("_").append("/").append(".".repeat(dotCount))
                .append("|".repeat(3)).append(".".repeat(dotCount)).append("\\").append("_");

        System.out.println(sb);
    }

    public static void printMiddlePart(int n, int width)   {
        int lineCount = (width - 3) / 2;
        for (int i = 0; i < n; i++) {
            System.out.println("_".repeat(lineCount) + "|".repeat(3) + "_".repeat(lineCount));
        }
        System.out.println("_".repeat(lineCount) + "~".repeat(3) + "_".repeat(lineCount));
    }

    public static void printBottom(int n)    {
        int lineCount = n / 2;
        int dotCount = 0;
        StringBuilder sb = new StringBuilder();

        while (lineCount > 0)   {
            sb.append("_".repeat(lineCount)).append("//").append(".".repeat(dotCount)).append("!")
                    .append(".".repeat(dotCount)).append("\\\\").append("_".repeat(lineCount)).append(System.lineSeparator());
            lineCount--;
            dotCount++;
        }
        System.out.println(sb);
    }
}
