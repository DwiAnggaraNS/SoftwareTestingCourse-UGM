import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class resultPage {
    WebDriver driver;

    public resultPage(WebDriver driver) {
        // Constructor
        this.driver = driver;
    }

    // Locator
    By searchResult = By.id("b_results");

    // Interaction
    public String getSearchResult() {
        return driver.findElement(searchResult).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
