import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Initialize Edge driver
        driver = new EdgeDriver();
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver
        driver.quit();
    }

    @Test
    public void testEdge() {
        // Test code for Edge
        driver.get("https://sv.ugm.ac.id/departemen-teknik-elektro-dan-informatika-dtedi/");
        String title = driver.getTitle();
        // Assert webpage
        assertEquals("Departemen Teknik Elektro dan Informatika (DTEDI) - Sekolah Vokasi UGM", title);
    }
}
