package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String inputPath = "resources/input.txt";
        String outputPath = "resources/02.WriteToFileOutput.txt";

        FileInputStream fis = new FileInputStream(inputPath);
        FileOutputStream fos = new FileOutputStream(outputPath);

        int oneByte = fis.read();

        while (oneByte != -1)   {
            if (!isPunctuation(oneByte))    {
                fos.write(oneByte);
            }
            oneByte = fis.read();
        }

    }

    private static boolean isPunctuation(int oneByte) {
        return oneByte == ',' || oneByte == '.' || oneByte == '!' || oneByte == '?';
    }
}
