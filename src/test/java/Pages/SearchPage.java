package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Driver;

import java.util.List;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath= "//a[@aria-label='Search']")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }

    @FindBy(xpath= "//input[@placeholder=\"What do you want to listen to?\"]")
    private WebElement searchLine;

    public WebElement getSearchLine() {
        return searchLine;
    }

    public void performSearch(){
        searchLine.sendKeys("Oasis Wonderwall", Keys.ENTER);
    }

    @FindBy(xpath="//div[@class='Type__TypeElement-sc-goli3j-0 kjfRyT nk6UgB4GUYNoAcPtAQaG']")
    private WebElement song;

    public WebElement getSong() {
        return song;
    }

    @FindBy(xpath= "//a[@href='/artist/2DaxqgrOhkeH0fpeiQq2f4'][1]")
    private WebElement artist;

    public WebElement getArtist() {
        return artist;
    }


    @FindBy(xpath= "//div[@class='Type__TypeElement-sc-goli3j-0 fZDcWX t_yrXoUO3qGsJS4Y6iXX standalone-ellipsis-one-line']")
    private List<WebElement> songsFromSongSection;

    public  List<WebElement> getsongsFromSongSection() {
        return songsFromSongSection;
    }





}
