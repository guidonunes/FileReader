import java.io.*;
import java.util.Scanner;

public class ShoppingListExample {
    public static void main(String[] args) {
        addItem();
        showList();
    }

    public static void addItem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Add an item to the shopping list (type 'quit' to finish): ");
        String item = sc.nextLine();

        while(!item.equalsIgnoreCase("quit")) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("list.txt", true))) {
                bw.write(item);
                bw.newLine();
                System.out.println(item + " has been successfuly added.");
            } catch (IOException e) {
                System.err.println("An error occurred. The item couldn't be added in the list.");
                e.printStackTrace();
            }
            System.out.println("\nAdd another item (or type 'quit' to finish.)");
            item = sc.nextLine();
        }
    }

    public static void showList() {
        System.out.println("\nShopping List:");
        try(BufferedReader br = new BufferedReader(new FileReader("list.txt"))) {
            String readItem;
            while((readItem = br.readLine()) != null) {
                System.out.println("- " + readItem);
            }
        } catch (IOException e) {
            System.err.println("Couldn't read file");
            e.printStackTrace();
        }
    }
}
