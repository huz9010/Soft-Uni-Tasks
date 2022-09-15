package DrawingOnTheConsole;

public class Rectangle1010Stars {
    public static void main(String[] args) {

        String symbol = "*";

        for (int i = 0; i < 10; i++) {
            System.out.println(generateFrom(10, symbol));
        }
    }
    public static String generateFrom (int numberOfStars, String symbol) {
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            builder.append(symbol);
        }
        return builder.toString();
        }
    }

