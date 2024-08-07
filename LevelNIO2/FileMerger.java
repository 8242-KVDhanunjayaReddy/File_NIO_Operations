package LevelNIO2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileMerger {
    public static void main(String[] args) {
        Path dir = Paths.get("path/to/your/directory");
        Path mergedFile = Paths.get("path/to/your/mergedFile.txt");

        try (Stream<Path> paths = Files.list(dir);
             FileChannel mergedFileChannel = FileChannel.open(mergedFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            paths.filter(Files::isRegularFile)
                    .forEach(file -> {
                        try (FileChannel fileChannel = FileChannel.open(file, StandardOpenOption.READ)) {
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            while (fileChannel.read(buffer) > 0) {
                                buffer.flip();
                                mergedFileChannel.write(buffer);
                                buffer.clear();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

