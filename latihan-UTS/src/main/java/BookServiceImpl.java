import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private Library library;

    public BookServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public List<Book> getAllBooks() {
        return library.getAllBooks();
    }

    @Override
    public Book findBookById(String id) {
        return library.getAllBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean saveBook(Book book) {
        return library.addBook(book);
    }

    @Override
    public boolean deleteBook(String id) {
        // Implementation not necessary for this example
        return false;
    }

    @Override
    public List<Book> findBooksByCategory(String category) {
        return library.getAllBooks().stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}