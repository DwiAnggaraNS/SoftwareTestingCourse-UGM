import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisterTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {

        // 1: Launch browser
        driver = new ChromeDriver();


        // 2: Navigate to the URL
        driver.get("https://automationexercise.com");
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver
        driver.quit();
    }

    @Test
    @Order(1)
    public void testRegisterFlow(){

        // 3: Verify that home page is visible successfully
        WebElement catergoryText = driver.findElement(By.xpath("//h2[contains(text(),'Category')]"));
        String expectedText = "CATEGORY";
        String actualText = catergoryText.getText();
        assertEquals(expectedText, actualText);

        // 4: Click on the "Signup / Login" button
        WebElement signupLoginButton = driver.findElement(By.linkText("Signup / Login"));
        signupLoginButton.click();

        // 5: Verify that "New User Signup!" is visible
        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
        String expectedSignupText = "New User Signup!";
        String actualSignupText = newUserSignupText.getText();
        assertEquals(expectedSignupText, actualSignupText);

        // 6: Enter name and email address
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        nameField.sendKeys("john dor");
        emailField.sendKeys("johndor@gmail.com");

        // 7: Click on "Signup" button
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();

        // 8: Verify that "ENTER ACCOUNT INFORMATION" is visible
        WebElement accountInfoText = driver.findElement(By.xpath("//h2[contains(.,'Enter Account Information')]"));

        String expectedAccountInfoText = "ENTER ACCOUNT INFORMATION";
        String actualAccountInfoText = accountInfoText.getText();
        assertEquals(expectedAccountInfoText, actualAccountInfoText);

        // 9: Fill details (title, Name, Email, Password, Date of birth)
        WebElement mrRadio = driver.findElement(By.id("id_gender1"));
        mrRadio.click();

        WebElement passwordField = driver.findElement(By.xpath("//input[@data-qa='password']"));
        passwordField.sendKeys("123123123");

        WebElement dayField = driver.findElement(By.xpath("//select[@id='days']"));
        dayField.sendKeys("14");

        WebElement monthField = driver.findElement(By.xpath("//select[@id='months']"));
        monthField.sendKeys("Desember");

        WebElement yearField = driver.findElement(By.xpath("//select[@id='years']"));
        yearField.sendKeys("2000");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ins.adsbygoogle")));

        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('ins.adsbygoogle').forEach(el => el.style.display = 'none');"
        );

        // 10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkboxField = driver.findElement(By.id("newsletter"));
        checkboxField.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkboxField2 = driver.findElement(By.id("optin"));
        checkboxField2.click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameField = driver.findElement(By.xpath("//input[@data-qa='first_name']"));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@data-qa='last_name']"));
        lastNameField.sendKeys("Dor");

        WebElement companyField = driver.findElement(By.xpath("//input[@data-qa='company']"));
        companyField.sendKeys("PT. TEMBAK TEMBAK DOR DOR DOR");

        WebElement addressField = driver.findElement(By.xpath("//input[@data-qa='address']"));
        addressField.sendKeys("Jl. Land Of Dawn");

        WebElement address2Field = driver.findElement(By.xpath("//input[@data-qa='address2']"));
        address2Field.sendKeys("Jl. Malioboro");

        WebElement countryField = driver.findElement(By.xpath("//select[@data-qa='country']"));
        countryField.sendKeys("Canada");

        WebElement stateField = driver.findElement(By.xpath("//input[@data-qa='state']"));
        stateField.sendKeys("Ontario");

        WebElement cityField = driver.findElement(By.xpath("//input[@data-qa='city']"));
        cityField.sendKeys("Toronto");

        WebElement zipcodeField = driver.findElement(By.xpath("//input[@data-qa='zipcode']"));
        zipcodeField.sendKeys("123456");

        WebElement mobileNumberField = driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
        mobileNumberField.sendKeys("1234567890");

        // 13. Click 'Create Account button'
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButton.click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedText = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        String expectedAccountCreatedText = "ACCOUNT CREATED!";
        String actualAccountCreatedText = accountCreatedText.getText();
        assertEquals(expectedAccountCreatedText, actualAccountCreatedText);

        // 15. Click 'Continue' button
        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();

        // 16. Verify that 'Logged in as username' is visible
        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        String expectedLoggedInText = "Logged in as john dor";
        String actualLoggedInText = loggedInText.getText();
        assertEquals(expectedLoggedInText, actualLoggedInText);
    }

    @Test
    @Order(2)
    public void testLoginFlow(){

        // 17. Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccountButton.click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedText = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        String expectedAccountDeletedText = "ACCOUNT DELETED!E-commerce solutions";
        String actualAccountDeletedText = accountDeletedText.getText();
        assertEquals(expectedAccountDeletedText, actualAccountDeletedText);

        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();
    }
}
