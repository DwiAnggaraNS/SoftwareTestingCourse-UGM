import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class LibraryHelperTest {

    // Jelaskan mengapa kita menggunakan mockito untuk testing
    // Karena mockito adalah framework yang memungkinkan kita untuk membuat object palsu (mock object) untuk menggantikan object asli dalam pengujian unit.
    // Dengan mockito, kita dapat menguji bagian tertentu dari kode tanpa harus menguji seluruh kode.
    // Dengan kata lain, mockito memungkinkan kita untuk mengisolasi kode yang ingin kita uji dari kode lain yang tidak ingin kita uji.
    // Dengan menggunakan mockito, kita dapat membuat object palsu yang menggantikan object asli yang digunakan dalam kode yang ingin kita uji.
    // Object palsu ini dapat kita atur untuk mengembalikan nilai tertentu ketika method tertentu dipanggil, sehingga kita dapat menguji bagian tertentu dari kode tanpa harus menguji seluruh kode.
    // Dengan menggunakan mockito, kita dapat menguji bagian tertentu dari kode tanpa harus menguji seluruh kode.


    // Jelaskan kegunaan annotation @ExtendWith(MockitoExtension.class)
    // @ExtendWith(MockitoExtension.class) digunakan untuk memberi tahu JUnit bahwa kita ingin menggunakan Mockito dalam pengujian unit.
    // Dengan menggunakan @ExtendWith(MockitoExtension.class), JUnit akan menggunakan MockitoExtension untuk menjalankan pengujian unit.
    // Jadi kita tidak perlu membuat object MockitoExtension secara eksplisit, karena JUnit akan membuat object MockitoExtension secara otomatis.

    @Mock
    private LibraryService service;


    @InjectMocks
    private LibraryHelper helper;

    // Jelaskan kegunaan annotation @Mock
    // @Mock digunakan untuk membuat object mock.
    // Dengan menggunakan @Mock, kita dapat membuat object mock yang digunakan dalam pengujian unit.

    // Jelaskan kegunaan annotation @InjectMocks
    // @InjectMocks digunakan untuk menginjeksi object mock ke dalam object yang ingin kita uji.
    // Dengan menggunakan @InjectMocks, kita dapat menginjeksi object mock ke dalam object yang ingin kita uji.


    @Test
    public void testCountBooks() {
        // Create a mock LibraryService
        // Create a LibraryHelper object using the mock LibraryService
        // Call the countBooks method on the LibraryHelper object
        // Verify that the countBooks method returns the correct number of books

        //  LibraryService service = new LibraryService(); -> ini seharusnya diubah menjadi mock karena kita tidak ingin mengakses database
        // Ini buat library service menggunakan mockito untuk testing
        LibraryService service = mock(LibraryService.class);

        // Create a list of books
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        books.add(new Book("Book 3", "Author 3", 3));

        // Mocking the behavior of the getAllBooks method
        Mockito.when(service.getAllBooks()).thenReturn(books);

//        LibraryHelper helper = new LibraryHelper(service);
        assertEquals(3, helper.countBooks());
    }

    @Test
    public void testSaveEmptyBooks(){
        LibraryService service = mock(LibraryService.class);

        LibraryHelper helper = new LibraryHelper(service);

        // Test with zero books
        List<Book> emptyBooks = new ArrayList<Book>();
        helper.saveBooks(emptyBooks);

        // Verifying that the saveBook method is not called on the mock LibraryService
        Mockito.verify(service, Mockito.never()).saveBook(any());
    }

    @Test
    public void testSaveBooks() {
        // Create a mock LibraryService
        // Create a LibraryHelper object using the mock LibraryService
        // Create a list of books
        // Call the saveBooks method on the LibraryHelper object
        // Verify that the saveBooks method is called on the mock LibraryService

        LibraryService service = mock(LibraryService.class);

        LibraryHelper helper = new LibraryHelper(service);

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        books.add(new Book("Book 3", "Author 3", 3));

        helper.saveBooks(books);

        // Verifying that the saveBook method is called on the mock LibraryService
        Mockito.verify(service, Mockito.times(1)).saveBook(books);

        // Jelasin setiap method pada mockito, seperti verify, when, never, times, dan method lainnya

        // Verify that the saveBook method is called on the mock LibraryService (selain menggunakan .times(1) bisa juga menggunakan .atLeastOnce())
        Mockito.verify(service, Mockito.atLeastOnce()).saveBook(books);

        // Verify that the saveBook method is called on the mock LibraryService exactly 1 time
        Mockito.verify(service).saveBook(books);

        // Method mock ini buat ngecek apakah method saveBook dipanggil atau tidak dalam method saveBooks
        // Nah analoginya kita ngecek apakah pelayan kita (service) sudah melakukan tugasnya yaitu menyampaikan pesanan ke dapur (saveBook)

    }
}
