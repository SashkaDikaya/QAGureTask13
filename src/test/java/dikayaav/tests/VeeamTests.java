package dikayaav.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;


public class VeeamTests extends TestBase {

    @Test
    @DisplayName("Поиск вакансии QA Automation")
    void findVacancyTest()  {
        step("Поиск вакансии QA Automation", () -> {
            Selenide.open("https://careers.veeam.ru/");
            $x("//input[@placeholder='Ключевое слово']").setValue("QA automation").pressEnter();
        });

        step("Открытие вакансии содержащей фразу 'с возможностью переезда в Прагу' ", () -> {
            $x("//*").shouldHave(text("с возможностью переезда в Прагу")).click();
        });
    }

    @ValueSource(strings = {"Biocad", "Exchange"})
    @ParameterizedTest(name = "Открытие статьи о : {0}")
    void checkSuccessStoryTest(String customer) {
        step("Открытие главной страницы сайта Veeam", () -> {
            Selenide.open("https://www.veeam.com/ru");
        });

        step("Открытие историй успеха заказчиков", () -> {
            $x("//a[text()='Истории успеха заказчиков']").click();
        });

        step("Поиск информации о " + customer, () -> {
            $x("//span[contains(text(),'Показать поле поиска')]").click();
            $x("//input[@class='form-input search-input']").setValue(customer).pressEnter();
        });

        step("Проверка наличия статьи о " + customer, () -> {
            $x("//div[@class='success-stories-listing__listing']").shouldHave(text(customer));
        });

        step("Открытие первой статьи о " + customer, () -> {
            $x("//a[text()='Подробнее']").click();
        });

        step("Проверка наличия информации в статье о " + customer, () -> {
            $x("//*").shouldHave(text(customer));
        });
    }

    @Test
    @DisplayName("Поиск информации о компании Biocad в скачанном PDF файле")
        void checkPdfTest() throws Exception {
            step("Поиск информации о компании Biocad в скачанном PDF файле", () -> {
                Selenide.open("https://www.veeam.com/ru/success-stories/Biocad.html");
                File downloadedPdfFile = $x("//span[contains(text(), 'Скачать PDF')]/..").download();
                PDF parsed = new PDF(downloadedPdfFile);
                assertThat(parsed.title).contains("Veeam", "Biocad");

            });
    }

    @Test
    @DisplayName("Смена языка с русского на английский")
    void changeLanguageTest()  {
        step("Смена языка с русского на английский", () -> {
            Selenide.open("https://www.veeam.com/ru");
            $x("//div[@class='language-selector']").click();
            $x("//a[@data-lang='en']").click();
            $x("//a[@class='additional-info__link contact-sales-link']").shouldHave(text("Contact Sales"));
        });
    }

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.phoneNumber().phoneNumber(),
            company = faker.ancient().god(),
            details = faker.elderScrolls().quote();

    @Test
    @DisplayName("Заполнение Запроса в отдел продаж")
    void fillFormTest()  {
        step("Заполнение Запроса в отдел продаж", () -> {
            Selenide.open("https://www.veeam.com/ru/salesinc.html?ad=in-text-link");
            $x("//input[contains(@id, 'first-name')]").setValue(firstName);
            $x("//input[contains(@id, 'last-name')]").setValue(lastName);
            $x("//input[contains(@id, 'email')]").setValue(email);
            $x("//input[contains(@id, 'phone')]").setValue(phone);
            $x("//input[contains(@id, 'company')]").setValue(company);
            $x("//textarea[contains(@id, 'details')]").setValue(details);
            $x("//div[@class='form-group js-products ']").click();
            $x("//div[@class='ss-content ss-open']").$(withText("Veeam ONE")).click();

        });
    }

}



