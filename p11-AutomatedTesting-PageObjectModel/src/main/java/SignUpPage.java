import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    WebDriver driver;

    public  SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
    By nameField = By.xpath("//input[@name='name']");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");

    // Interaction
    public String getNewUserSignupText() {
        return driver.findElement(newUserSignupText).getText();
    }
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

}
