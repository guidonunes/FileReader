import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManipulation {
    public static void main(String[] args) {
        Path path = Paths.get("home/games.txt");
        System.out.println("File path: " + path);
    }
}
