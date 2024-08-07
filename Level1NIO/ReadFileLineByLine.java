package Level1NIO;

import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        Path filePath = Paths.get("source.txt");

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> {
                // Process each line here
                System.out.println(line);
            });
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
