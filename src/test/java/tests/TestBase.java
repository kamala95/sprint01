package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
import java.util.logging.Logger;

public class TestBase {
    private static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setupTest () {
        Driver.getDriver().manage().window().maximize ();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        Driver.quitDriver();
    }

}
