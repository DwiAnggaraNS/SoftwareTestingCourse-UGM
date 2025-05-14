import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeAfterLoginPage {
    WebDriver driver;

    public  HomeAfterLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By accountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    // Interaction
    public String getAccountCreatedText() {
        return driver.findElement(accountCreatedText).getText();
    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
