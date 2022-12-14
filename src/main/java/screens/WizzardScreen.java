package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WizzardScreen extends BaseScreen{
    public WizzardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")
    MobileElement skipButton;

    public HomeScreeen skipWizzard(){
        should(skipButton,10);
        skipButton.click();
        return new HomeScreeen(driver);
    }
}
