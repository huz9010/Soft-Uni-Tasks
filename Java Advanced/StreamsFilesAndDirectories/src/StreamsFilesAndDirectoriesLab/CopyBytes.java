package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) throws IOException  {

        String inputPath = "resources/input.txt";
        String outputPath = "resources/03.CopyBytesOutput.txt";

        FileReader reader = new FileReader(inputPath);
//        FileOutputStream fos = new FileOutputStream(outputPath);
        PrintWriter printer = new PrintWriter(outputPath);
        FileWriter writer = new FileWriter(outputPath);

        int oneByte = reader.read();

        while (oneByte != -1)   {
            if (oneByte != 13 && oneByte != 32)   {
                printer.print(String.valueOf(oneByte));
            }   else {
                writer.write((char) oneByte);
            }
            oneByte = reader.read();
        }

        reader.close();
        writer.close();
        printer.close();
    }
}
