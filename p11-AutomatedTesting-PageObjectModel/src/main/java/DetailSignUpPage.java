import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailSignUpPage {
    WebDriver driver;

    public  DetailSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By accountInfoText = By.xpath("//h2[contains(.,'Enter Account Information')]");
    By mrRadio = By.id("id_gender1");
    By passwordField = By.xpath("//input[@data-qa='password']");
    By dayField = By.xpath("//select[@id='days']");
    By monthField = By.xpath("//select[@id='months']");
    By yearField = By.xpath("//select[@id='years']");
    By newsletterCheckbox = By.id("newsletter");
    By optinCheckbox = By.id("optin");
    By firstNameField = By.xpath("//input[@data-qa='first_name']");
    By lastNameField = By.xpath("//input[@data-qa='last_name']");
    By companyField = By.xpath("//input[@data-qa='company']");
    By addressField = By.xpath("//input[@data-qa='address']");
    By address2Field = By.xpath("//input[@data-qa='address2']");
    By countryField = By.xpath("//select[@data-qa='country']");
    By stateField = By.xpath("//input[@data-qa='state']");
    By cityField = By.xpath("//input[@data-qa='city']");
    By zipcodeField = By.xpath("//input[@data-qa='zipcode']");
    By mobileNumberField = By.xpath("//input[@data-qa='mobile_number']");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    // Interaction
    public String getAccountInfoText() {
        return driver.findElement(accountInfoText).getText();
    }
    public void clickMrRadio() {
        driver.findElement(mrRadio).click();
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void selectDay(String day) {
        driver.findElement(dayField).sendKeys(day);
    }
    public void selectMonth(String month) {
        driver.findElement(monthField).sendKeys(month);
    }
    public void selectYear(String year) {
        driver.findElement(yearField).sendKeys(year);
    }
    public void clickNewsletterCheckbox() {
        driver.findElement(newsletterCheckbox).click();
    }
    public void clickOptinCheckbox() {
        driver.findElement(optinCheckbox).click();
    }
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void enterCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void enterAddress2(String address2) {
        driver.findElement(address2Field).sendKeys(address2);
    }
    public void selectCountry(String country) {
        driver.findElement(countryField).sendKeys(country);
    }
    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }
    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }
    public void enterZipcode(String zipcode) {
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }
    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();
    }
}
