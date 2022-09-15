package June2019;

import java.util.Scanner;

public class FavouriteMovie {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int maxString = 0;
        int movieCount = 0;
        String favMovie = "";
        boolean outOfLimit = false;

        while (!movie.equals("STOP"))   {
            movieCount++;
            int capitalL= 0;
            int nonCapital = 0;
            int charSum = 0;

            if (movieCount >= 7) {
                System.out.printf("The limit is reached.%n" +
                        "The best movie for you is %s with %d ASCII sum.", favMovie, maxString);
                outOfLimit = true;
                break;
            }

            for (int i = 0; i < movie.length(); i++) {
                char a = movie.charAt(i);
                charSum = charSum + a;

                if (a >= 65 && a <= 90) {
                    capitalL++;
                }   else if (a >= 97 && a <= 122)   {
                    nonCapital++;
                }
            }
            charSum = charSum - capitalL * movie.length() - nonCapital * 2 * movie.length();
            if (charSum > maxString)    {
                maxString = charSum;
                favMovie = movie;
            }
            movie = scanner.nextLine();
        }
        if (!outOfLimit)    {
            System.out.printf("The best movie for you is %s with %d ASCII sum.", favMovie, maxString);
        }
    }
}
