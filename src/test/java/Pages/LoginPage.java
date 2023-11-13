package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import static org.testng.Assert.assertTrue;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id= "login-username")
    private WebElement usernameField;

    public WebElement getUsernameField() {
        return usernameField;
    }

    public void validLogin(){
        usernameField.sendKeys("emilyjohnson202324@gmail.com", Keys.TAB,"DuotechNew12", Keys.ENTER);
    }

    public void invalidLogin(){
        usernameField.sendKeys("emilyjohnson202324@gmail.com", Keys.TAB, "Duotech2022", Keys.ENTER);
    }

    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement loginButton1;

    public WebElement validLogin1(){
        return loginButton1;
    }

    @FindBy(xpath = "//div[@data-testid='placeholder-wrapper']")
    private WebElement profileIcon;

    public WebElement validProfileIcon(){
        return profileIcon;
    }

    @FindBy(xpath = "(//button[@class='wC9sIed7pfp47wZbmU6m'])[1]")
    private WebElement accountPage;
    public WebElement getAccountPage(){
        return accountPage;
    }

    @FindBy(xpath = "//div[@aria-describedby='onClickHintchangePassword']")
    private WebElement changePasswordBtn;

    public WebElement getChangePasswordBtn() {
        return changePasswordBtn;
    }

    @FindBy(xpath = "//input[@id='old_password']")
    private WebElement currentPassword;

    public WebElement getCurrentPassword() {
        return currentPassword;
    }

    @FindBy(xpath = "//div[@class='Wrapper-sc-62m9tu-0 hdvLLY encore-positive-set']")
    private WebElement positivePasswordChange;

    public WebElement getPositivePasswordChange() {
        return positivePasswordChange;
    }

    public String positivePasswordChangeMsg(){
        return getPositivePasswordChange().getText();
    }
}
