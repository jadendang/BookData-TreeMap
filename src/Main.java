import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, Book> bookMap = loadBooksFromFile();

        System.out.println("Number of books loaded: " + bookMap.size());

        String isbnToSearch = "0439023483";
        Book book = bookMap.get(isbnToSearch);
        if (book != null) {
            System.out.println("Book found with ISBN " + isbnToSearch + ":");
            System.out.println("Book Title: " + book.getTitle());
        } else {
            System.out.println("Book with ISBN " + isbnToSearch + " not found.");
        }
        System.out.println();

        Book newBook = new Book("0440178002", "James Clavell", 1975, "Shogun: The Epic Novel of Japan", "Shogun", 4.4);
        bookMap.put(newBook.getIsbn(), newBook);
        System.out.println("Adding new book with ISBN: " + newBook.getIsbn());
        System.out.println("Added new book: " + newBook.getOriginalTitle());
        System.out.println();

        String isbnToRemove = "0439023483";
        Book removedBook = bookMap.remove(isbnToRemove);
        if (removedBook != null) {
            System.out.println("Removed book: " + removedBook.getTitle());
        } else {
            System.out.println("Book with ISBN " + isbnToRemove + " not found for removal.");
        }

        System.out.println();
        String[] sortedKeys = bookMap.keySet().toArray(new String[0]);
        System.out.println("List of Sorted Keys: ");
        for (String key : sortedKeys) {
            System.out.println(key);
        }
    }


    private static TreeMap<String, Book> loadBooksFromFile() {
        TreeMap<String, Book> bookMap = new TreeMap<>();
        try {
            File file = new File("src/BooksDataFile.txt");
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("~");

                String isbn = parts[2];
                String authors = parts[3];
                int pubYear = Integer.parseInt(parts[4]);
                String originalTitle = parts[5];
                String title = parts[6];
                double avgRating = Double.parseDouble(parts[7]);

                Book book = new Book(isbn, authors, pubYear, originalTitle, title, avgRating);
                bookMap.put(isbn, book);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return bookMap;
    }
}
