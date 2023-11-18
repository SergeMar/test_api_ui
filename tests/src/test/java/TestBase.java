import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    MainPage mainPage = new MainPage();
    CalendlyPage calendlyPage = new CalendlyPage();

    @BeforeEach
    public void openUrl() {
        System.setProperty("selenide.browser", "firefox");
        BrowserManager.navigateTo("https://www.getsorbet.com/");
    }
}
