import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RemoveFileExample {
    public static void main(String[] args) {
        try {
            Files.delete(Path.of("list_copied.txt"));
            System.out.println("File successfuly removed");

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
