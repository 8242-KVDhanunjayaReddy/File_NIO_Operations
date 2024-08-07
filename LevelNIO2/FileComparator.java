package LevelNIO2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileComparator {

    private static final int BUFFER_SIZE = 1024 * 1024;

    public static boolean areFilesEqual(String filePath1, String filePath2) throws IOException {
        try (RandomAccessFile file1 = new RandomAccessFile(filePath1, "r");
             RandomAccessFile file2 = new RandomAccessFile(filePath2, "r");
             FileChannel channel1 = file1.getChannel();
             FileChannel channel2 = file2.getChannel()) {

            if (channel1.size() != channel2.size()) {
                return false;
            }

            long size = channel1.size();
            long position = 0;

            while (position < size) {
                long remaining = size - position;
                long chunkSize = Math.min(BUFFER_SIZE, remaining);

                MappedByteBuffer buffer1 = channel1.map(FileChannel.MapMode.READ_ONLY, position, chunkSize);
                MappedByteBuffer buffer2 = channel2.map(FileChannel.MapMode.READ_ONLY, position, chunkSize);

                for (int i = 0; i < chunkSize; i++) {
                    if (buffer1.get(i) != buffer2.get(i)) {
                        return false;
                    }
                }

                position += chunkSize;
            }

            return true; 
        }
    }

    public static void main(String[] args) {
        try {
            String filePath1 = "path/to/first/large/file";
            String filePath2 = "path/to/second/large/file";

            boolean areEqual = areFilesEqual(filePath1, filePath2);
            System.out.println("Files are equal: " + areEqual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

