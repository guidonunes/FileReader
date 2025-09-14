import javax.naming.directory.BasicAttribute;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class GetFileDataExample {
    public static void main(String[] args) {
        Path file = Paths.get("games.txt");
        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("Size: " + attr.size());
            System.out.println("Created at: " + attr.creationTime());
            System.out.println("Last modified: " + attr.lastModifiedTime());
            System.out.println("Is Directory: " + attr.isDirectory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
