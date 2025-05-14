import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisterTest {

    static WebDriver driver;
    static HomePage homePage;
    static SignUpPage signUpPage;
    static DetailSignUpPage detailSignUpPage;
    static HomeAfterLoginPage homeAfterLoginPage;
    static AfterDeletedPage afterDeletedPage;

    @BeforeAll
    public static void setUp() {

        // 1: Launch browser
        driver = new ChromeDriver();

        // 2: Navigate to the URL
        driver.get("https://automationexercise.com");

        // 3. Define Page Object Model
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        detailSignUpPage = new DetailSignUpPage(driver);
        homeAfterLoginPage = new HomeAfterLoginPage(driver);
        afterDeletedPage = new AfterDeletedPage(driver);
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
        String expectedText = "CATEGORY";
        String actualText = homePage.getCatergoryText();
        assertEquals(expectedText, actualText);

        // 4: Click on the "Signup / Login" button
        homePage.clickSignupLoginButton();

        // 5: Verify that "New User Signup!" is visible
        String expectedSignupText = "New User Signup!";
        String actualSignupText = signUpPage.getNewUserSignupText();
        assertEquals(expectedSignupText, actualSignupText);

        // 6: Enter name and email address
        signUpPage.enterName("john dor");
        signUpPage.enterEmail("johndor@gmail.com");

        // 7: Click on "Signup" button
        signUpPage.clickSignupButton();

        // 8: Verify that "ENTER ACCOUNT INFORMATION" is visible
        String expectedAccountInfoText = "ENTER ACCOUNT INFORMATION";
        String actualAccountInfoText = detailSignUpPage.getAccountInfoText();
        assertEquals(expectedAccountInfoText, actualAccountInfoText);

        // 9: Fill details (title, Name, Email, Password, Date of birth)
        detailSignUpPage.clickMrRadio();
        detailSignUpPage.enterPassword("123123123");
        detailSignUpPage.selectDay("14");
        detailSignUpPage.selectMonth("Desember");
        detailSignUpPage.selectYear("2000");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ins.adsbygoogle")));

        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('ins.adsbygoogle').forEach(el => el.style.display = 'none');"
        );

        detailSignUpPage.clickNewsletterCheckbox();
        detailSignUpPage.clickOptinCheckbox();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        detailSignUpPage.enterFirstName("John");
        detailSignUpPage.enterLastName("Dor");
        detailSignUpPage.enterCompany("PT. AWS");
        detailSignUpPage.enterAddress("Jl. Land Of Dawn");
        detailSignUpPage.enterAddress2("Jl. Malioboro");
        detailSignUpPage.selectCountry("Canada");
        detailSignUpPage.enterState("Ontario");
        detailSignUpPage.enterCity("Toronto");
        detailSignUpPage.enterZipcode("123456");
        detailSignUpPage.enterMobileNumber("1234567890");

        // 13. Click 'Create Account button'
        detailSignUpPage.clickCreateAccountButton();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        String expectedAccountCreatedText = "ACCOUNT CREATED!";
        String actualAccountCreatedText = homeAfterLoginPage.getAccountCreatedText();
        assertEquals(expectedAccountCreatedText, actualAccountCreatedText);

        // 15. Click 'Continue' button
        homeAfterLoginPage.clickContinueButton();

        // 16. Verify that 'Logged in as username' is visible
        String expectedLoggedInText = "Logged in as john dor";
        String actualLoggedInText = homePage.getLoggedInText();
        assertEquals(expectedLoggedInText, actualLoggedInText);
    }

    @Test
    @Order(2)
    public void testLoginFlow(){
        // 17. Click 'Delete Account' button
        homePage.clickDeleteAccountButton();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String expectedAccountDeletedText = "ACCOUNT DELETED!";
        String actualAccountDeletedText = afterDeletedPage.getAccountDeletedText();
        assertEquals(expectedAccountDeletedText, actualAccountDeletedText);

        // 19. Click 'Continue' button
        homePage.clickContinueButton();
    }
}
