package Org.Policy.Base;

import Org.Policy.Factory.DriverManager;
import Org.Policy.Utils.TestUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    TestUtils testUtils = new TestUtils();
    String dateAndTime;


    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){

        this.driver.set(driver);
    }

    public WebDriver getDriver(){

       return this.driver.get();
    }

    @Parameters({"Browser"})
    @BeforeMethod
    public void startDriver(String Browser){

        setDriver(new DriverManager().initializeDriver(Browser));

    }

    @Parameters({"Browser"})
    @AfterMethod
    public void quitDriver(String Browser, ITestResult result) throws IOException {

        if(result.getStatus() == ITestResult.FAILURE){

            File DestFile = new File("Screenshot" + File.separator + Browser + dateTime()
            + result.getTestClass().getRealClass().getSimpleName() + "_"
            + result.getMethod().getMethodName() + ".png");

            getScreenshot(DestFile);

        }



        getDriver().quit();

    }

    public void getScreenshot(File DestFile) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File scr = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr, DestFile);

    }



    public void getDateTime(){

         dateAndTime = testUtils.getDateTime();

    }

    public String dateTime(){

        return dateAndTime;

    }



}
