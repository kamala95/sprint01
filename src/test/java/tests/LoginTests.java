package tests;

import Pages.LoginPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.SignUpPage;

import utils.Driver;

public class LoginTests extends TestBase{
    @Test(groups = "smoke")
    public void positiveLogin() {

        LoginPage loginPage = new LoginPage();

        loginPage.validLogin1().click();
        loginPage.validLogin();
        Assert.assertTrue(loginPage.validProfileIcon().isDisplayed());
    }


}
