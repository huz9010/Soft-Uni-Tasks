package WhileLoopMoreExercises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int c = 0;
        int o = 0;
        int n = 0;
        String word = "";

        while (!input.equals("End"))    {
            char letter = input.charAt(0);

            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {

                switch (letter) {
                    case 'c':
                        if (c > 0){
                            word += letter;
                        }
                        c++;
                        break;
                    case 'o':
                        if (o > 0){
                            word += letter;
                        }
                        o++;
                        break;
                    case 'n':
                        if (n > 0)  {
                            word += letter;
                        }
                        n++;
                        break;
                    default:
                        word += letter;
                }
            }
            if (c > 0 && o > 0 && n > 0) {
                System.out.print(word + " ");
                c = 0;
                o = 0;
                n = 0;
                word = "";
            }
            input = scanner.nextLine();
        }
    }
}
