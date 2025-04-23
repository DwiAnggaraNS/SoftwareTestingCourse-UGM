import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryStatisticsTest {
    private LibraryStatistics libraryStats;
    private BookService mockBookService;
    @BeforeEach
    public void setup() {
        // Create a mock for the BookService
        mockBookService = mock(BookService.class);
        // Initialize LibraryStatistics with mock
        libraryStats = new LibraryStatistics(mockBookService);
    }

    @Test
    public void testCountTotalBooks(){
        //Mock boook service
        BookService service = mock(BookService.class);

        // Create books
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("1", "Book 1", "Author 1", 1000,"Category 1"));
        books.add(new Book("2", "Book 2", "Author 2", 2000,"Category 2"));
        books.add(new Book("3", "Book 3", "Author 3", 2000,"Category 3"));

        when(service.getAllBooks()).thenReturn(books);

        // Create library statistics
        LibraryStatistics libraryStatistics = new LibraryStatistics(service);
        int totalBooks = libraryStatistics.countTotalBooks();
        assertEquals(3, totalBooks);
    }

    @Test
    @DisplayName("Test count books by category")
    public void testCountBooksByCategory() {
        // Setup mock books for the "Science" category
        ArrayList<Book> scienceBooks = new ArrayList<Book>();
//        new Book("B1", "Physics", "Author 1", 2020, "Science"),
        scienceBooks.add(new Book("B2", "Chemistry", "Author 2", 2021, "Science"));
        scienceBooks.add(new Book("B3", "Biology", "Author 3", 2022, "Science"));

        // Stub the findBooksByCategory method to return our mock list
        when(mockBookService.findBooksByCategory("Science")).thenReturn(scienceBooks);
        when(mockBookService.findBooksByCategory("Fiction")).thenReturn(Collections.emptyList());

        // Execute the methods to test
        int scienceCount = libraryStats.countBooksByCategory("Science");
        int fictionCount = libraryStats.countBooksByCategory("Fiction");

        // Assert the results
        assertEquals(2, scienceCount, "Science book count should be 2");
        assertEquals(0, fictionCount, "Fiction book count should be 0");

        // Verify method calls
        verify(mockBookService, times(1)).findBooksByCategory("Science");
        verify(mockBookService, times(1)).findBooksByCategory("Fiction");
    }

}