import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocatorAndActionExerciseTest {

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
    public void testLocatorAndActionExercise() {

        //Locate
        WebElement queryInput = driver.findElement(By.id("sb_form_q"));
        WebElement form = driver.findElement(By.id("sb_form"));

        //Interactions
        queryInput.sendKeys("Selenium");
        form.submit();

        //Assertions
        String expectedTitle = "Selenium - Bing";
        String actualTitle = driver.getTitle();
    }

    @Test
    public void testLoginPassed() {
        driver.get("https://www.saucedemo.com/");

        // Locate elements
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Interactions
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Assertions
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        // Verify the URL using AsserEquals
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void testLoginError() {
        driver.get("https://www.saucedemo.com/");

        // Locate elements
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Interactions
        usernameField.sendKeys("standard_users");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Assertions
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));

        // Verify using AsserEquals
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedErrorMessage, errorMessage.getText());
    }
}
