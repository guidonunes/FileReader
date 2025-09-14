import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFileExample {
    public static void main(String[] args) {
        try {
            Path origin = Paths.get("list.txt");
            Path destination = Paths.get("list_copied.txt");
            Files.copy(origin, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File successfuly copied.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
