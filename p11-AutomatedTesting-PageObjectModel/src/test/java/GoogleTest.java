import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    @Test
    public void testSearch() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        searchPage search = new searchPage(driver);
        search.enterSearchQuery("Selenium");
        search.formSubmit();
        String expectedTitle = "Selenium - Penelusuran Google";
        resultPage result = new resultPage(driver);
        String actualTitle = result.getTitle();
        assertEquals(expectedTitle, actualTitle);
        // Close the browser
        driver.quit();
    }
}
