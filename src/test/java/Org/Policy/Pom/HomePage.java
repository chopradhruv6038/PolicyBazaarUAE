package Org.Policy.Pom;

import Org.Policy.Base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loadUrl(String url){

        driver.get(url);

    }

}
