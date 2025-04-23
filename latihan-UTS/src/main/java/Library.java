import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add book to library
    public boolean addBook(Book book) {
        // Check if book with same ID already exists
        if (books.stream().anyMatch(b -> b.getId().equals(book.getId()))) {
            return false;
        }
        return books.add(book);
    }

    // Get all books in library
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Search books by title (partial match)
    public List<Book> searchBooksByTitle(String titleQuery) {
        if (titleQuery == null || titleQuery.trim().isEmpty()) {
            throw new IllegalArgumentException("Search query cannot be empty");
        }

        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(titleQuery.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Borrow a book by ID
    public boolean borrowBook(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            return false;
        }

        for (Book book : books) {
            if (book.getId().equals(bookId) && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    // Return a book by ID
    public boolean returnBook(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            return false;
        }

        for (Book book : books) {
            if (book.getId().equals(bookId) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    // Get count of books by category
    public int getBookCountByCategory(String category) {
        if (category == null) {
            return 0;
        }

        return (int) books.stream()
                .filter(book -> category.equals(book.getCategory()))
                .count();
    }

    // Get books published between years (inclusive)
    public List<Book> getBooksByYearRange(int startYear, int endYear) {
        if (startYear > endYear) {
            throw new IllegalArgumentException("Start year must be less than or equal to end year");
        }

        if (startYear < 1000 || endYear > 9999) {
            throw new IllegalArgumentException("Year must be a 4-digit number");
        }

        return books.stream()
                .filter(book -> book.getPublicationYear() >= startYear &&
                        book.getPublicationYear() <= endYear)
                .collect(Collectors.toList());
    }
}