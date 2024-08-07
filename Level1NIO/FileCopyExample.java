package Level1NIO;

import java.nio.file.*;

public class FileCopyExample {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("path/to/source/file.txt");
        Path targetPath = Paths.get("path/to/target/file.txt");

        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
