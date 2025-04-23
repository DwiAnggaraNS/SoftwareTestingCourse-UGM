import java.util.List;

public class LibraryStatistics {
    private BookService bookService;

    public LibraryStatistics(BookService bookService) {
        this.bookService = bookService;
    }

    public int countTotalBooks() {
        return bookService.getAllBooks().size();
    }

    public int countBooksByCategory(String category) {
        return bookService.findBooksByCategory(category).size();
    }

    public double calculateAveragePublicationYear() {
        List<Book> allBooks = bookService.getAllBooks();
        if (allBooks.isEmpty()) {
            return 0;
        }

        int sum = allBooks.stream()
                .mapToInt(Book::getPublicationYear)
                .sum();

        return (double) sum / allBooks.size();
    }
}