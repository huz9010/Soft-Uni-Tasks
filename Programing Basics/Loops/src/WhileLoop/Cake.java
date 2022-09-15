package WhileLoop;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cakeWidth = Integer.parseInt(scanner.nextLine());
        int cakeLength = Integer.parseInt(scanner.nextLine());
        int pieces = cakeLength * cakeWidth;

        while (pieces > 0)  {
            String input = scanner.nextLine();
            if (input.equals("STOP")) {
                break;
            }
            int piecesTaken = Integer.parseInt(input);
            pieces = pieces - piecesTaken;
            }
        if (pieces <= 0)    {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(pieces));
        }   else {
            System.out.printf("%d pieces are left.", pieces);
        }
    }
}
