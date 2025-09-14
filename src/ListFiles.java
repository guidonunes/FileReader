import java.io.IOException;
import java.nio.file.*;

public class ListFiles {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/guilherme/Documents/FIAP_repos/FileReader");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch(IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
}
