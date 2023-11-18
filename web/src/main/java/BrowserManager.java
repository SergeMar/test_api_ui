import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.switchTo;

public class BrowserManager {

    public static String currentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public static void navigateTo(String url) {
        if (!BrowserManager.hasStarted() || !currentUrl().equals(url)) {
            Selenide.open(url);
            WebDriverRunner.getWebDriver().manage().window().maximize();
        } else {
            reloadPage();
        }
    }

    private static boolean hasStarted() {
        return WebDriverRunner.hasWebDriverStarted();
    }

    private static void reloadPage() {
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    public static void toCalendlyPage() {
        switchTo().window(1);
    }
}
