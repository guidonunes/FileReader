import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteFileExample {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("Resident Evil 4", "Baldur's Gate 3", "Horizon: Forbidden West", "Death Stranding 2");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("games.txt", true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
