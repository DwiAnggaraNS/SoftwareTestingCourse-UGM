import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public  HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By catergoryText = By.xpath("//h2[contains(text(),'Category')]");
    By signupLoginButton = By.linkText("Signup / Login");
    By LoggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteAccountButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By continueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");


    // Interaction
    public String getCatergoryText() {
        return driver.findElement(catergoryText).getText();
    }
    public void clickSignupLoginButton() {
        driver.findElement(signupLoginButton).click();
    }
    public String getLoggedInText() {
        return driver.findElement(LoggedInText).getText();
    }
    public void clickDeleteAccountButton() {
        driver.findElement(deleteAccountButton).click();
    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
