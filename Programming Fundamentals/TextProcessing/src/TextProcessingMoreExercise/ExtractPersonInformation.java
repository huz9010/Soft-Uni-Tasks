package TextProcessingMoreExercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= lines; i++) {
            String sentence = scanner.nextLine();
            StringBuilder name = new StringBuilder();
            StringBuilder age = new StringBuilder();
            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == '@') {
                    while (sentence.charAt(j + 1) != '|'){
                        name.append(sentence.charAt(j + 1));
                        j++;
                    }
                } else if (sentence.charAt(j) == '#') {
                    while (sentence.charAt(j + 1) != '*'){
                        age.append(sentence.charAt(j + 1));
                        j++;
                    }
                }
            }
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
