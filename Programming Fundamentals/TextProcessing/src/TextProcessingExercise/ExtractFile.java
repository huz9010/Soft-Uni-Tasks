package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder path = new StringBuilder(scanner.nextLine());
        int endIndex = path.lastIndexOf("\\");
        path.replace(0, endIndex + 1, "");

        String fileName = path.toString().split("\\.")[0];
        String fileExtension = path.toString().split("\\.")[1];

        System.out.printf("File name: %s%n" +
                "File extension: %s", fileName, fileExtension);
    }
}
