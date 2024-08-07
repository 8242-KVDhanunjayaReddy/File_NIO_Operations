package LevelNIO2;

import java.io.*;
import java.nio.file.*;

public class FindAndReplace {
    public static void main(String[] args) {
        Path path = Paths.get("path/to/your/file.txt");
        Path tempPath = Paths.get("path/to/your/tempfile.txt");
        String target = "targetText";
        String replacement = "replacementText";

        try (BufferedReader reader = Files.newBufferedReader(path);
             BufferedWriter writer = Files.newBufferedWriter(tempPath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replace(target, replacement);
                writer.write(modifiedLine);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(path);
            Files.move(tempPath, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

