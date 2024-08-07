package Level1NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class ReadFileToString {
    public static void main(String[] args) {

        Path filePath = Paths.get("path/to/your/file.txt");

        try {

            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {

            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
