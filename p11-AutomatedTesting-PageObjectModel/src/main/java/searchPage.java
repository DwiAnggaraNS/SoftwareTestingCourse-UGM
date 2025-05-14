import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchPage {

    WebDriver driver;

    public searchPage(WebDriver driver) {
        // Constructor
        this.driver = driver;
    }

    // Locator
    By searchBox = By.xpath("//*[@id=\"APjFqb\"]");
    By searchForm = By.xpath("/html/body/div[1]/div[3]/form");

    // Interaction
    public void enterSearchQuery(String query) {
        driver.findElement(searchBox).sendKeys(query);
    }

    public void formSubmit() {
        driver.findElement(searchForm).submit();
    }
}
