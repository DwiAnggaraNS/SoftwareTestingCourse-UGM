import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Initialize Chrome driver
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver
        driver.quit();
    }

    @Test
    public void testChrome() {
        // Test code for Chrome
        driver.get("https://sv.ugm.ac.id/departemen-teknik-elektro-dan-informatika-dtedi/");
        String title = driver.getTitle();
        // Assert webpage
        assertEquals("Departemen Teknik Elektro dan Informatika (DTEDI) - Sekolah Vokasi UGM", title);
    }
}
