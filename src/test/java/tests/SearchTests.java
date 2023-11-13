package tests;

import Pages.LoginPage;
import Pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SearchTests extends TestBase {

   @Test (groups = "smoke")
    public void searchButtonDisplayedAfterValidLogin() {
        SearchPage searchPage = new SearchPage();
        LoginPage loginPage = new LoginPage();
        loginPage.validLogin1().click();
        loginPage.validLogin();
        Assert.assertTrue(searchPage.getSearchButton().isDisplayed());
    }

   @Test (groups = "smoke")
    public void searchForSongAfterValidLogin() {
        SearchPage searchPage = new SearchPage();
        LoginPage loginPage = new LoginPage();
        loginPage.validLogin1().click();
        loginPage.validLogin();
        searchPage.getSearchButton().click();
        searchPage.performSearch();
        Assert.assertEquals(searchPage.getSong().getText(),ConfigReader.getProperty("songname"));
        Assert.assertEquals(searchPage.getArtist().getText(),ConfigReader.getProperty("artistname"));
    }

    @Test (groups = "smoke")
   public void searchResultsContainSongNameAfterLogin() {
       SearchPage searchPage = new SearchPage();
       LoginPage loginPage = new LoginPage();
       loginPage.validLogin1().click();
       loginPage.validLogin();
       searchPage.getSearchButton().click();
       searchPage.performSearch();
       List<WebElement> songs = searchPage.getsongsFromSongSection();
       for (WebElement song : songs) {
           String songText = song.getText();
           assertTrue(songText.contains(ConfigReader.getProperty("songname")));
       }
   }




}
