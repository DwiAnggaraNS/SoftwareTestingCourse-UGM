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
public class WaitStrategiesHomeworkTest {
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
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @AfterEach
    public void clearImplicitWait() {
        // Clear implicit wait after each test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
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
    public void testCase1WithoutExplicitWait(){
        // Locate elements
        WebElement addButton = driver.findElement(By.id("add_btn"));
        // Interactions
        addButton.click();

        // Locate the element after clicking
        WebElement row2 = driver.findElement(By.xpath("//*[@id=\"row2\"]/label"));

        // Assertions
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed");
        String expectedText = "Row 2";
        assertEquals(expectedText, row2.getText(), "Row 2");
    }

    @Test
    @Order(2)
    public void testCase1WithExplicitWait(){
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Locate elements
        WebElement addButton = driver.findElement(By.id("add_btn"));
        // Interactions
        addButton.click();

        // Explicit Wait for field row 2
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement row2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"row2\"]/label"))
        );

        // Assertions
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed");
        String expectedText = "Row 2";
        assertEquals(expectedText, row2.getText(), "Row 2");
    }

    @Test
    @Order(3)
    public void testCase3WithoutProperSteps(){
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Locate elements
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"row1\"]/input"));

        // Interactions
        inputField.clear();
        inputField.sendKeys("Karedok Leunca");

        // Verify text in the input field
        String expectedText = "Karedok Leunca";
        String actualText = inputField.getAttribute("value");
        assertEquals(expectedText, actualText, "Input field should contain 'Karedok Leunca'");
    }

    @Test
    @Order(4)
    public void testCase3WithProperSteps(){
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Locate elements
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"row1\"]/input"));
        WebElement editButton = driver.findElement(By.id("edit_btn"));
        WebElement saveButton = driver.findElement(By.id("save_btn"));

        // Interactions
        editButton.click();
        inputField.clear();
        inputField.sendKeys("Karedok Leunca");
        saveButton.click();

        // Verify text in the input field
        String expectedText = "Karedok Leunca";
        String actualText = inputField.getAttribute("value");
        assertEquals(expectedText, actualText, "Input field should contain 'Karedok Leunca'");
    }

    @Test
    @Order(5)
    public void testCase4NegativeCase(){
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Locate elements
        WebElement addButton = driver.findElement(By.id("add_btn"));
        WebElement instructionText = driver.findElement(By.xpath("//*[@id=\"instructions\"]"));

        //Verify text in the instruction text
        String expectedText = "Push “Add” button to add another row";
        String actualText = instructionText.getText();
        assertEquals(expectedText, actualText, "Instruction text should be 'Push “Add” button to add another row'");

        // Interactions
        addButton.click();
        // Verify text in the instruction text
        WebElement instructionTextAfterAddRow = driver.findElement(By.xpath("//*[@id=\"instructions\"]"));
        String actualTextAfterAddRow = instructionTextAfterAddRow.getText();
        assertEquals(expectedText, actualTextAfterAddRow, "Instruction text should be 'Push “Add” button to add another row'");
    }

    @Test
    @Order(6)
    public void testCase4PositiveCase(){
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Locate elements
        WebElement addButton = driver.findElement(By.id("add_btn"));
        WebElement instructionText = driver.findElement(By.xpath("//*[@id=\"instructions\"]"));

        //Verify text in the instruction text
        String expectedText = "Push “Add” button to add another row";
        String actualText = instructionText.getText();
        assertEquals(expectedText, actualText, "Instruction text should be 'Push “Add” button to add another row'");

        // Interactions
        addButton.click();

        // Wait for instruction text to disappear using Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(instructionText));

        // Assert that the element became invisible
        assertTrue(isInvisible, "Instruction text should not be displayed after adding a row");
    }

    @Test
    @Order(7)
    public void testCase5WithoutProperWaitStrategy(){
        // Locate elements
        WebElement addButton = driver.findElement(By.id("add_btn"));
        // Interactions
        addButton.click();

        // Explicit Wait for error message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement row2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"row2\"]/label"))
        );

        // Assertions
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed");
        String expectedText = "Row 2";
        assertEquals(expectedText, row2.getText(), "Row 2");
    }

    @Test
    @Order(8)
    public void testCase5WithProperThreadSleep(){
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Locate elements
        WebElement addButton = driver.findElement(By.id("add_btn"));
        // Interactions
        addButton.click();

        // Thread.sleep for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Locate the element after clicking
        WebElement row2 = driver.findElement(By.xpath("//*[@id=\"row2\"]/label"));

        // Assertions
        assertTrue(row2.isDisplayed(), "Row 2 should be displayed");
        String expectedText = "Row 2";
        assertEquals(expectedText, row2.getText(), "Row 2");
    }
}
