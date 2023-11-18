import org.junit.jupiter.api.Test;

public class WebTest extends TestBase {

    @Test
    public void sorbetTest() {
        openUrl();
        mainPage.clickScheduleDemoButton();
        calendlyPage.toPage()
                .fillForm()
                .submit();
    }
}
