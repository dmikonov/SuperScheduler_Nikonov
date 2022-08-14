package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Event;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class EditCreateEventScreen extends BaseScreen {
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breakPlusBtn;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']")
    List<MobileElement> days;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']")
    List<MobileElement> month;

    public HomeScreeen createNewEvent(Event event) {
        should(title, 5);
        type(title, event.getTitle());
        type(type, event.getType());
        driver.hideKeyboard();
        int breaks = event.getBreaks();
        if (breaks > 0 && breaks < 5) {
            for (int i = 0; i < breaks; i++) {
                breakPlusBtn.click();
            }
        }
        wageEdit.click();
        type(wageInput, String.valueOf(event.getWage()));
        wageSave.click();
        confirmCreation.click();
        return new HomeScreeen(driver);
    }

    public EditCreateEventScreen dataAction() {
        pause(3000);
        MobileElement elementDay = days.get(2);
        Rectangle rect = elementDay.getRect();
        int xFrom = rect.getX() + rect.getWidth()/2;
        int y = rect.getY() + rect.getHeight()/2;
        int xTo = driver.manage().window().getSize().getWidth()/2;
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release().perform();
        return this;
    }
    public EditCreateEventScreen selectDataAction(String data) {
        LocalDate inputData = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate current = getLocalDate(days.get(0).getText(),month.get(0).getText());
        while(!inputData.equals(current)){
            dataAction();
            pause(1000);
            current = getLocalDate(days.get(0).getText(),month.get(0).getText());
        }

        return this;
    }

    private LocalDate getLocalDate(String day, String month) {
        month = month.toLowerCase();
        month = month.substring(0,1).toUpperCase()+month.substring(1);
        String data = day+"/"+month+"/"+"2022";
        LocalDate a = LocalDate.parse(data, DateTimeFormatter.ofPattern("d/MMMM/yyyy"));
        return a;
    }
}
