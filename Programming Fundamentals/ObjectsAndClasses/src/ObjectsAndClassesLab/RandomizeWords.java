package ObjectsAndClassesLab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (!wordList.isEmpty())  {
            Random rnd = new Random();
            int randomIndex = rnd.nextInt(wordList.size());
            System.out.println(wordList.get(randomIndex));
            wordList.remove(randomIndex);
        }
    }
}
