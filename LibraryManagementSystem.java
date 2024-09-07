import java.util.ArrayList;
import java.util.List;
class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + (isCheckedOut ? "Checked Out" : "Available");
    }
}
class LibraryCatalog {
    private List<Book> books;
    public LibraryCatalog() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }
    public boolean checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()) {
                book.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }
    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()) {
                book.setCheckedOut(false);
                return true;
            }
        }
        return false;
    }
    public String printInfo() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        catalog.addBook(new Book("1984", "George Orwell"));


        System.out.println("Search by title '1984':");
        for (Book book : catalog.searchByTitle("1984")) {
            System.out.println(book);
        }
        System.out.println("\nChecking out '1984':");
        if (catalog.checkOutBook("1984")) {
            System.out.println("Checked out successfully.");
        } else {
            System.out.println("Book not available.");
        }

        System.out.println("\nReturning '1984':");
        if (catalog.returnBook("1984")) {
            System.out.println("Returned successfully.");
        } else {
            System.out.println("Book was not checked out.");
        }
        System.out.println("\nLibrary Catalog:");
        System.out.println(catalog.printInfo());
    }
}
