package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchTest extends Configuration {

    @Test
    public void LaunchTest(){
        String version = new SplashScreen(driver).getCurrencyVersion();
        Assert.assertEquals(version,"0.0.3");
    }
}
