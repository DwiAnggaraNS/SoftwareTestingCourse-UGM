import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WaitStrategiesTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Initialize Chrome driver
        driver = new ChromeDriver();
        // Maximize window for better visibility
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void navigateToLoginPage() {
        // Navigate to the login page before each test
        driver.get("https://www.saucedemo.com/");
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void testLoginPassedWithImplicitWait() {
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

        // Verify the URL using assertEquals
        assertEquals(expectedUrl, actualUrl, "Login should redirect to inventory page");
        
        // Reset implicit wait to avoid affecting other tests
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    @Test
    @Order(2)
    public void testLoginErrorWithExplicitWait() {
        // Locate elements
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Interactions
        usernameField.clear();  // Clear field in case of previous input
        passwordField.clear();  // Clear field in case of previous input
        usernameField.sendKeys("standard_users");  // Incorrect username
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Explicit Wait for error message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']"))
        );

        // Assertions
        assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedErrorMessage, errorMessage.getText(), "Error message text should match");
    }
    
    @Test
    @Order(3)
    public void testWithFluentWait() {
        // Example of using Fluent Wait
        WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait.pollingEvery(Duration.ofMillis(500))
                 .ignoring(org.openqa.selenium.NoSuchElementException.class);
        
        // Locate elements
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Interactions
        usernameField.sendKeys("problem_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
        
        // Wait for inventory container with Fluent Wait
        WebElement inventoryContainer = fluentWait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container"))
        );
        
        // Assert
        assertTrue(inventoryContainer.isDisplayed(), "Inventory container should be visible");
    }
}