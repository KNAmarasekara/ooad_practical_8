import java.util.ArrayList;
import java.util.Scanner;
 
// a. book
class Book {
    private String isbn;
    private String title;
 
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
 
    public String getIsbn() {
        return isbn;
    }
 
    public void displayDetails() {
        System.out.println("ISBN: " + isbn + ", Title: " + title);
    }
}
 
    //main
    public class LibraryInventory{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> inventory = new ArrayList<>();
 
        // b.
        while (true) {
            System.out.print("Enter ISBN (-99 to finish): ");
            String isbn = sc.nextLine();
            if (isbn.equals("-99")) {
                break;
            }
            System.out.print("Enter title: ");
            String title = sc.nextLine();
            inventory.add(new Book(isbn, title));
        }
 
        // c.
        System.out.print("Enter the ISBN of the book to remove: ");
        String target = sc.nextLine();
        boolean removed = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getIsbn().equals(target)) {
                inventory.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("ISBN not found. No book removed.");
        }
 
        // d.
        System.out.println("Total number of books: " + inventory.size());
 
        // e.
        for (Book b : inventory) {
            b.displayDetails();
        }
        
    }
}
