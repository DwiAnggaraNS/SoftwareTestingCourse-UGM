import java.util.List;

public class LibraryHelper {

    public LibraryService libraryService;

    public LibraryHelper(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public int countBooks() {
        List<Book> books = libraryService.getAllBooks();
        return books.size();
    }

    public void saveBooks(List <Book> books) {
        if (books.size() > 0) {
            this.libraryService.saveBook(books);
        }
    }
}
