package tests;

import Pages.LoginPage;
import Pages.SignUpPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends TestBase {

    @Test(groups = "smoke")
    public void signUpTest() throws InterruptedException {

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getSigUpButton().click();
        signUpPage.enterEmail(SignUpPage.generateRandomEmail());
        Thread.sleep(1000);
        signUpPage.getSignUpNextButton().click();
        Thread.sleep(1000);
        signUpPage.getPassword().sendKeys(SignUpPage.generateRandomPassword());
        Thread.sleep(1000);
        signUpPage.getSignUpNextButton().click();

        signUpPage.getNameField().sendKeys(SignUpPage.generateRandomName());
        Thread.sleep(1000);

        signUpPage.setDateDay();
        Thread.sleep(1000);

        signUpPage.setDateMonth();
        Thread.sleep(1000);

        signUpPage.setDateYear();
        Thread.sleep(1000);

        signUpPage.selectRandomRadioButton();
        Thread.sleep(1000);
        signUpPage.getSignUpNextButton().click();
        Thread.sleep(1000);

        signUpPage.checkAllCheckboxes();
        signUpPage.getSignUpNextButton().click();
        Thread.sleep(5000);


        Assert.assertTrue(signUpPage.validProfileIcon().isDisplayed());

    }

    @Test(groups = "smoke")
    public void signUpNegativeTest() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getSigUpButton().click();
        signUpPage.enterEmail("abrorollimov@gmail.com");
        signUpPage.getSignUpNextButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(signUpPage.getErrorMsg(),"This address is already linked to an existing account. To continue, log in.");
    }


}
