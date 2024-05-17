import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeMapTest {

    @Test
    void putAndGet() {
        TreeMap<String, Book> bookTest = new TreeMap<>();
        Book book1 = new Book("12345", "Author one", 2001, "OriginalBook", "Book1", 5.0);
        Book book2 = new Book("34567", "Author two", 2005, "BookTitle", "Book2", 4.5);

        bookTest.put(book1.getIsbn(), book1);
        bookTest.put(book2.getIsbn(), book2);

        assertEquals(book1, bookTest.get("12345"));
        assertEquals(book2, bookTest.get("34567"));
    }

    @Test
    void containsKey() {
        TreeMap<String, Book> bookTest = new TreeMap<>();
        Book book1 = new Book("12345", "Author one", 2001, "OriginalBook", "Book1", 5.0);
        Book book2 = new Book("34567", "Author two", 2005, "BookTitle", "Book2", 4.5);

        bookTest.put(book1.getIsbn(), book1);

        assertTrue(bookTest.containsKey("12345"));
        assertFalse(bookTest.containsKey("34567"));
    }

    @Test
    void toKeyArray() {
        TreeMap<String, Book> bookMap = new TreeMap<>();
        Book book1 = new Book("12345", "Author one", 2001, "OriginalBook", "Book1", 5.0);
        Book book2 = new Book("34567", "Author two", 2005, "BookTitle", "Book2", 4.5);

        bookMap.put(book1.getIsbn(), book1);
        bookMap.put(book2.getIsbn(), book2);

        String[] keyArray = bookMap.toKeyArray(new String[bookMap.size()]);

        assertEquals(book1.getIsbn(), keyArray[0]);
        assertEquals(book2.getIsbn(), keyArray[1]);
    }
}