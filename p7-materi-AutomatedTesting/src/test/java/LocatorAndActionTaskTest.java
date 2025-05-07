import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocatorAndActionTaskTest {

    static WebDriver driver;
    static Actions builder;

    @BeforeEach
    public void setUp() {
        // Initialize Chrome driver
        driver = new ChromeDriver();
        builder= new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void tearDown() {
        // Quit the driver
        driver.quit();
    }

    @Test
    @Order(1)
    public void testTugasHover(){

        // First: Navigate to the "Hovers" page
        WebElement elementToGoToHovers = driver.findElement(By.linkText("Hovers"));
        elementToGoToHovers.click();

        // Second: Hover over the first image
        WebElement firstImage = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        builder.moveToElement(firstImage).perform();

        //Assertion
        WebElement firstImageText = driver.findElement(By.xpath("//div[@class='figure'][1]//h5"));
        String expectedText = "name: user1";
        String actualText = firstImageText.getText();
        assertEquals(expectedText, actualText);
    }

    @Test
    @Order(2)
    public void testTugasDragAndDrop() {
        // First: Navigate to the "Drag and Drop" page
        WebElement elementToGoToDragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
        elementToGoToDragAndDrop.click();

        // Second: Perform drag and drop action
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        builder.dragAndDrop(source, target).perform();

        // Third: Validate that the columns are swapped
        WebElement headerA = driver.findElement(By.xpath("//div[@id='column-a']/header"));
        WebElement headerB = driver.findElement(By.xpath("//div[@id='column-b']/header"));

        assertEquals("B", headerA.getText());
        assertEquals("A", headerB.getText());
    }

    @Test
    @Order(3)
    public void testTugasKeyPresses() {
        // First: Navigate to the "Key Presses" page
        WebElement elementToGoToKeyPresses = driver.findElement(By.linkText("Key Presses"));
        elementToGoToKeyPresses.click();

        // Second: Perform key press action
        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.SHIFT);


        // Third: Validate the result
        WebElement result = driver.findElement(By.id("result"));
        String expectedText = "You entered: SHIFT";
        String actualText = result.getText();
        assertEquals(expectedText, actualText);
    }
}
