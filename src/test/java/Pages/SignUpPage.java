package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;
import java.util.Random;

public class SignUpPage {
    private final JavascriptExecutor executor;
    private static final Faker faker = new Faker();

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateRandomPassword() {
        return faker.internet().password();
    }
    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        executor = (JavascriptExecutor) Driver.getDriver();
    }

    @FindBy(xpath = "//button[@class='Button-sc-1dqy6lx-0 eOxaqu sibxBMlr_oxWTfBrEz2G']")
    private WebElement sigUpButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@data-testid='submit']")
    private WebElement signUpNextButton;

    @FindBy(xpath = "//input[@id='new-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='displayName']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='day']")
    private WebElement dateDay;

    @FindBy(xpath = "//select[@id='month']")
    private WebElement dateMonth;

    @FindBy(xpath = "//input[@id='year']")
    private WebElement dateyear;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> radioButtons;

    public WebElement getSigUpButton() {
        return sigUpButton;
    }

    public WebElement getSignUpNextButton() {
        return signUpNextButton;
    }

    public WebElement getPassword() {
        return passwordField;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getDateDay() {
        return dateDay;
    }

    public WebElement getDateMonth() {
        return dateMonth;
    }

    public WebElement getDateyear() {
        return dateyear;
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setDateDay() {
        getDateDay().sendKeys("" + (int) (Math.random() * 30 + 1));
    }

    public void setDateMonth() {
        if (getDateMonth().isDisplayed() && getDateMonth().isEnabled()) {
            Select monthDropdown = new Select(getDateMonth());
            List<WebElement> monthOptions = monthDropdown.getOptions();
            int randomIndex = new Random().nextInt(monthOptions.size());
            monthDropdown.selectByIndex(randomIndex);
        } else {
            System.out.println("Dropdown is not visible or enabled.");
        }
    }

    public void setDateYear() {
        getDateyear().sendKeys("" + (int) (Math.random() * 111 + 1900));
    }

    public void selectRandomRadioButton() {
        if (!radioButtons.isEmpty()) {
            int randomIndex = new Random().nextInt(radioButtons.size());
            executor.executeScript("arguments[0].click();", radioButtons.get(randomIndex));
        } else {
            System.out.println("No radio buttons found on the page.");
        }
    }



    @FindBy(xpath = "//input[@id='checkbox-marketing']")
    private WebElement marketingCheckbox;

    public WebElement getMarketingCheckbox() {
        return marketingCheckbox;
    }

    @FindBy(xpath = "//input[@id='checkbox-privacy']")
    private WebElement privacyCheckbox;

    public WebElement getPrivacyCheckbox() {
        return privacyCheckbox;
    }

    @FindBy(xpath = "//input[@id='terms-conditions-checkbox']")
    private WebElement termsCheckbox;

    public WebElement getTermsCheckbox() {
        return termsCheckbox;
    }

    public void checkAllCheckboxes() {
        clickCheckbox(getMarketingCheckbox());
        clickCheckbox(getPrivacyCheckbox());
        clickCheckbox(getTermsCheckbox());
    }

    private void clickCheckbox(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", checkbox);
        }
    }

    @FindBy(xpath = "//div[@data-testid='placeholder-wrapper']")
    private WebElement profileIcon;

    public WebElement validProfileIcon(){
        return profileIcon;
    }

    @FindBy(xpath = "//div[@data-encore-id='banner']")
    private WebElement errorField;

    public WebElement getErrorField() {
        return errorField;
    }

    public String getErrorMsg(){
        return getErrorField().getText();
    }

}
