package Level1NIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFileExample {
    public static void main(String[] args) {

        Path filePath = Paths.get("example.txt");


        List<String> lines = Arrays.asList("First line", "Second line", "Third line");

        try {

            Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

