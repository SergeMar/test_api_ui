import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class MainPage {
    public static final SelenideElement SCHEDULE_DEMO_BUTTON = $(xpath("//span[contains(text(), 'Schedule a demo')]"));

    public void clickScheduleDemoButton() {
        SCHEDULE_DEMO_BUTTON.shouldBe(visible).click();
    }
}
