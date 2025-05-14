import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AfterDeletedPage {
    WebDriver driver;

    public  AfterDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    // Interaction
    public String getAccountDeletedText() {
        return driver.findElement(accountDeletedText).getText();
    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
