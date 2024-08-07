package Level1NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class DeleteFileExample {
    public static void main(String[] args) {

        Path path = Paths.get("path/to/your/file.txt");

        try {
            Files.delete(path);
            System.out.println("File deleted successfully.");
        } catch (IOException e) {

            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

