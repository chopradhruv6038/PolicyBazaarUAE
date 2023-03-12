package Org.Policy.Tests;

import Org.Policy.Base.BaseTest;
import Org.Policy.Pom.HomePage;
import Org.Policy.Utils.TestUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class TravelInsuranceTests extends BaseTest {

    HomePage homePage;
    TestUtils testUtils;

    Properties props;
    InputStream GlobalProps;
    String GlobalData;


    @BeforeClass
    public void beforeClass() throws IOException {

        try {

            props = new Properties();
            GlobalData = "Data/config.properties";
            GlobalProps = getClass().getClassLoader().getResourceAsStream(GlobalData);
            props.load(GlobalProps);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(GlobalProps!=null){
                GlobalProps.close();
            }
        }

    }

    @BeforeMethod
    public void beforeMethod(Method m){

        homePage = new HomePage(getDriver());
        testUtils = new TestUtils();

        testUtils.log().info(m.getName());


    }

    @Test
    public void getTravelInsuranceQuote(){

        homePage.loadUrl(props.getProperty("policyBazaarUrl"));

    }

}
