import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class PhotoManagerApp {
    private static final String PHOTOS_DIR = "Photos";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Path photosDir = Paths.get(PHOTOS_DIR);
            if(Files.notExists(photosDir)) {
                Files.createDirectory(photosDir);
            }

            int option;
            do {
                System.out.println("\nPhoto Manager App:" +
                        "\n1. Show Photos" +
                        "\n2. Copy Photo" +
                        "\n3. Delete Photo" +
                        "\n4. Show Info" +
                        "\n5. Exit" +
                        "\n Choose an option: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        showPhotos(photosDir);
                        break;
                    case 2:
                        copyPhoto(photosDir);
                        break;
                    case 3:
                        deletePhoto(photosDir);
                        break;
                    case 4:
                        showInfo(photosDir);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                    default:
                        System.out.println("Invalid option");
                }

            } while(option != 5);

        } catch (IOException e) {
            System.err.println("Coudn't access photos directory.");
            e.printStackTrace();
        }
    }

    private static void showPhotos(Path directory) throws IOException {
        System.out.println("Photos:");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for(Path file : stream) {
                if (!Files.isDirectory(file)) {
                    System.out.println(file.getFileName());
                }
            }
        }
    }

    private static void copyPhoto(Path directory) throws IOException {
        System.out.println("Enter the name of the photo to be copied: ");
        Path photoOriginal = directory.resolve(scanner.nextLine());

        System.out.println("Enter the path: ");
        Path path = Paths.get(scanner.nextLine());
        if(Files.notExists(path)) {
            Files.createDirectories(path);
        }

        Path photoCopy = path.resolve(photoOriginal.getFileName());
        Files.copy(photoOriginal, photoCopy, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Photo successfully copied.");
    }

    private static void deletePhoto(Path directory) throws IOException {
        System.out.println("Enter the name of the photo to be deleted: ");
        Path photo = directory.resolve(scanner.nextLine());

        Files.deleteIfExists(photo);
        System.out.println("Photo successfully deleted.");
    }

    private static void showInfo(Path directory) throws IOException {
        System.out.println("Enter the name of the photo to visualize the info: ");
        Path photo = directory.resolve(scanner.nextLine());

        BasicFileAttributes attrs = Files.readAttributes(photo, BasicFileAttributes.class);
        System.out.println("Photo info: " +
                "\nSize: " + attrs.size() + " bytes" +
                "\nCreated at: " + attrs.creationTime() +
                "\nLast modified: " + attrs.lastModifiedTime() +
                "\nPath: " + photo.toAbsolutePath());
    }
}
