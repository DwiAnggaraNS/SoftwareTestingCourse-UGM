import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private static Library library;
    private static Book testBook1;
    private static Book testBook2;
    private static Book testBook3;

    // Test Lifecycle Methods
    @BeforeAll
    public static void setupClass() {
        System.out.println("Setting up test class - executed once before all tests");
        // Initialize any shared resources that will be used by all tests
    }

    @BeforeEach
    public void setup() {
        System.out.println("Setting up before each test");
        // Initialize fresh instances for each test to ensure test isolation
        library = new Library();

        // Create test books
        testBook1 = new Book("B12345", "Java Programming", "John Doe", 2020, "Programming");
        testBook2 = new Book("B67890", "Data Structures", "Jane Smith", 2019, "Programming");
        testBook3 = new Book("B54321", "Machine Learning", "Bob Johnson", 2021, "AI");

        // Add test books to library
        library.addBook(testBook1);
        library.addBook(testBook2);
        library.addBook(testBook3);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Cleaning up after each test");
        // Clean up resources for each test if needed
        library = null;
        testBook1 = null;
        testBook2 = null;
        testBook3 = null;
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Cleaning up after all tests");
        // Clean up any shared resources
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("B11111", "New Book", "Alice", 2022, "Fiction");
        assertTrue(library.addBook(newBook), "Book should be added successfully");
        assertEquals(4, library.getAllBooks().size(), "Library should contain 4 books after adding a new one");
    }

    @Test
    @DisplayName("Test add book with duplicate ID")
    public void testAddBookDuplicateId() {
        Book duplicateBook = new Book("B12345", "Duplicate Book", "Duplicate Author", 2022, "Fiction");
        boolean result = library.addBook(duplicateBook);

        assertFalse(result, "Adding a book with existing ID should return false");
        assertEquals(3, library.getAllBooks().size(), "Library should still contain 3 books");
    }

    // Parameterized Tests with CsvSource for Equivalence Classes
    @ParameterizedTest
    @CsvSource({
            "Java, 1", // Should find "Java Programming"
            "Data, 1", // Should find "Data Structures"
            "Machine, 1", // Should find "Machine Learning"
            "Programming, 0", // Case-sensitive title match
            "java, 1" // Case-insensitive search
    })
    @DisplayName("Test search books by title with equivalence classes")
    public void testSearchBooksByTitle(String query, int expectedCount) {
        List<Book> results = library.searchBooksByTitle(query);
        assertEquals(expectedCount, results.size(),
                "Search for '" + query + "' should return " + expectedCount + " books");
    }
}