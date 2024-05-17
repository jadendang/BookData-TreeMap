public class Book {
    private final String isbn;
    private final String authors;
    private final int publicationYear;
    private final String originalTitle;
    private final String title;
    private final double avgRating;

    public Book(String isbn, String authors, int publicationYear, String originalTitle, String title, double avgRating) {
        this.isbn = isbn;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.originalTitle = originalTitle;
        this.title = title;
        this.avgRating = avgRating;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public double getAvgRating() {
        return avgRating;
    }
}
