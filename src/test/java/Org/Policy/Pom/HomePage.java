package Org.Policy.Pom;

import Org.Policy.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //UI Definitions

    By policyBazaarHmPgLogo = By.xpath("//img[@src='https://cdn.policybazaar.ae/common/images/logo.svg']");

    By travelInsuranceLinkHmPg = By.cssSelector("a[href='https://www.policybazaar.ae/travel-insurance/buy-insurance/?utm_source=homepage&utm_medium=icon&utm_campaign=internal']");



    //a[@href="https://www.policybazaar.ae/travel-insurance/buy-insurance/?utm_source=homepage&utm_medium=icon&utm_campaign=internal"]

    public void loadUrl(String url) {

        driver.get(url);

    }

    public HomePage assertHmPgLogo() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(policyBazaarHmPgLogo)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(policyBazaarHmPgLogo)).isEnabled());

        return this;

    }

    public TravelOutOfUAE clickTravelInsurance() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(travelInsuranceLinkHmPg)).click();

        return new TravelOutOfUAE(driver);
    }


}
