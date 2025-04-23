import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book findBookById(String id);
    boolean saveBook(Book book);
    boolean deleteBook(String id);
    List<Book> findBooksByCategory(String category);
}