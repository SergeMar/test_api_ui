import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

public class CalendlyPage {
    public static final SelenideElement FIRST_NAME_FIELD = $(cssSelector("input[aria-label='First name']"));
    public static final SelenideElement LAST_NAME_FIELD = $(cssSelector("input[aria-label='Last name']"));
    public static final SelenideElement BUSINESS_EMAIL_FIELD = $(cssSelector("input[type=email]"));
    public static final SelenideElement COMPANY_NAME_FIELD = $(cssSelector("[data-component='923e77c1-155e-4803-aad9-61a17cc8bac2'] input"));
    public static final SelenideElement DEPARTMENT = $(cssSelector("[aria-label='Department']"));
    public static final SelenideElement SELECT_OTHER = $(cssSelector("[id*=Other]"));
    public static final SelenideElement QUESTION = $(cssSelector("[aria-label='Does your company pay out unused PTO at termination?']"));
    public static final SelenideElement NUMBER_OF_EMPLOYERS = $(cssSelector("[aria-label='Number of Employees']"));
    public static final SelenideElement SELECT_NUMBER = $(cssSelector("[id$='1-100']"));
    public static final SelenideElement SELECT_NO = $(cssSelector("[id*=No]"));
    public static final SelenideElement SUBMIT_BUTTON = $(cssSelector("[type=submit]"));

    public CalendlyPage fillForm() {
        fillFirstName()
                .fillLastName()
                .fillBusinessEmail()
                .fillCompanyName()
                .selectDepartment()
                .selectNumberOfEmployers()
                .selectAnswer();
        return this;
    }

    private CalendlyPage selectNumberOfEmployers() {
        NUMBER_OF_EMPLOYERS.click();
        SELECT_NUMBER.should(appear).click();
        return this;
    }

    public void submit() {
        SUBMIT_BUTTON.shouldBe(visible).click();
    }

    private CalendlyPage selectAnswer() {
        QUESTION.click();
        SELECT_NO.should(appear).click();
        return this;
    }

    private CalendlyPage selectDepartment() {
        DEPARTMENT.click();
        SELECT_OTHER.should(appear).click();
        return this;
    }

    private CalendlyPage fillCompanyName() {
        COMPANY_NAME_FIELD.sendKeys("BB");
        return this;
    }

    private CalendlyPage fillBusinessEmail() {
        BUSINESS_EMAIL_FIELD.sendKeys("bill_brown@mail.ru");
        return this;
    }

    private CalendlyPage fillLastName() {
        LAST_NAME_FIELD.sendKeys("Brown");
        return this;
    }

    private CalendlyPage fillFirstName() {
        FIRST_NAME_FIELD.shouldBe(visible).sendKeys("Bill");
        return this;
    }

    public CalendlyPage toPage() {
        BrowserManager.toCalendlyPage();
        return this;
    }
}
