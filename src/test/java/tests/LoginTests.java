package tests;

import Pages.LoginPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.SignUpPage;

import utils.Driver;
import utils.SeleniumUtils;

public class LoginTests extends TestBase{

    @Test(groups = "smoke")
    public void positiveLogin() {

        LoginPage loginPage = new LoginPage();
        loginPage.validLogin1().click();
        loginPage.validLogin();
        Assert.assertTrue(loginPage.validProfileIcon().isDisplayed());
    }

    @Test(groups = "smoke")
    public void negativeLogin() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage();
        LoginPage loginPage = new LoginPage();
        loginPage.validLogin1().click();
        Thread.sleep(1000);
        loginPage.invalidLogin();
        Assert.assertEquals(signUpPage.getErrorMsg(),"Incorrect username or password.");
    }

//    @Test(groups = "smoke")
//    public void passwordResetAndLogin() throws InterruptedException {
//        SignUpPage signUpPage = new SignUpPage();
//        LoginPage loginPage = new LoginPage();
//        loginPage.validLogin1().click();
//        loginPage.validLogin();
//        loginPage.validProfileIcon().click();
//        loginPage.getAccountPage().click();
//        Thread.sleep(3000);
//        SeleniumUtils.switchToWindow("Spotify");
//        Thread.sleep(3000);
//        SeleniumUtils.scroll(0,1000);
//        loginPage.getChangePasswordBtn().click();
//        loginPage.getCurrentPassword().sendKeys("DuotechNew12", Keys.TAB, "DuotechAcademy2023", Keys.TAB, "DuotechAcademy2023", Keys.ENTER);
//        Thread.sleep(5000);
//        Assert.assertEquals(loginPage.positivePasswordChangeMsg(),"Password updated");
//    }

}
