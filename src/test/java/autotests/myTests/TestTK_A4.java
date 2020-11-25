package autotests.myTests;

import autotests.BaseTest;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TK_A4.Appeals;
import pages.TK_A4.CreateAppeals;
import pages.TK_A4.DataEntryAppeals;
import pages.createTest.NewPhysicalPerson;
import pages.createTest.DataEntry;
import pages.createTest.LoginPage;
import pages.MainPage;
import utils.BasicInfo;
import utils.ContactInfo;
import utils.ContactInfoAppeals;
import utils.User;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestTK_A4 extends BaseTest {

    @BeforeMethod
    @Step("Выполнение предусловий")
    public void beforeMethod() {
        //авторизация
        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(User.TEST_USER.getUsername(), User.TEST_USER.getPassword());
    }

    @Test(description = "Тест - Создание физического лица")
    @Description("Проверка появления меню")
    public void exampleTestPageObjectWithParent() {

        DataEntryAppeals dataEntryAppeals = page(DataEntryAppeals.class);

        checkAppearanceMenu();
        clickParagAppeals();
        clickCreateAppeals();
        clickDataEntryAppeals(dataEntryAppeals);
        entrySurname(dataEntryAppeals);
        entryEmail(dataEntryAppeals);
        clickSearch(dataEntryAppeals);
        clickChoicePhysPerson(dataEntryAppeals);
//        fillFieldCategory(dataEntryAppeals);
//        fillFieldSubtype(dataEntryAppeals);
//        fillFieldTopic(dataEntryAppeals);
//        fillFieldSubject(dataEntryAppeals);
//        fillFieldDescription(dataEntryAppeals);

    }

    @Step("Шаг 1. Проверка появления меню")
    public void checkAppearanceMenu() {

        //наводимся на вкладку "Все"
        MainPage mainPage = page(MainPage.class);
        //наводимся на вкладку "Все"
        mainPage.getAllTab().hover();
        //проверяем, что выпадающее меню-список отображается
        mainPage.getAllDropdown().should(Condition.appear);

    }

    @Step("Шаг 2. Из выпадающего списка выбрать пункт «Обращения».")
    public void clickParagAppeals() {

        Appeals appears = page(Appeals.class);
        //Клик на пункт "Обращения"
        appears.getClickAppeals().scrollIntoView(true).click();
        // Проверка, что открыт модуль «Обращения» («Cases»).
        appears.getShouldAppeals().should(Condition.appear);

    }

    @Step("Шаг 3. В меню модуля выбрать пункт «Создать обращение».")
    public void clickCreateAppeals() {

        CreateAppeals createAppeals = page(CreateAppeals.class);
        //Клик на пункт «Создать обращение»
        createAppeals.getClickCreateAppeals().click();
        // Открыта форма создания обращения.
        //createAppeals.getShouldCreateAppeals().shouldBe(visible);

    }

    @Step("Шаг 4. В разделе «Контактная информация» заполнить поле «Контактное лицо»")
    public void clickDataEntryAppeals(DataEntryAppeals  dataEntryAppeals) {

        //Клик на стрелочку у поля «Контактная информация»
        $(By.id("btn_contact_created_by_name")).click();
        //Переход в другую вкладку браузера
        switchTo().window(1);
        // Проверка, что открыта форма поиска контактов.
        dataEntryAppeals.getShouldOpenFormCearchContact().shouldBe(visible);

    }

    @Step("Шаг 5. В поле «ФИО» ввести фамилию физического лица из предусловия.")
    public void entrySurname(DataEntryAppeals  dataEntryAppeals) {

        dataEntryAppeals.ContInSurname(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getSurname());

        // Проверка, что поле «ФИО» заполнено.
        //lastName = $(By.id("last_name")).getValue();
    }

    @Step("Шаг 6. В поле «Любой E-mail» ввести E-mail физического лица из предусловия.")
    public void entryEmail(DataEntryAppeals  dataEntryAppeals) {

        dataEntryAppeals.ContInEmail(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getEmail());

        // Проверка, что поле «Любой E-mail» заполнено.
        //lastName = $(By.id("last_name")).getValue();
    }

    @Step("Шаг 7. Нажать на кнопку «Найти»")
    public void clickSearch(DataEntryAppeals dataEntryAppeals) {

        // Клик на кнопку найти
        $(By.id("search_form_submit")).click();
        //Проверка, что появилась одна запись
        $$(".list>tbody tr").shouldBe(size(1));

        dataEntryAppeals.getShouldHaveSurname().shouldHave(Condition.
                text(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getSurname()));
        dataEntryAppeals.getShouldHaveEmail().shouldHave(Condition.
                text(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getEmail()));

   }

    @Step("Шаг 8. Выбрать физическое лицо из формы просмотра списка физических лиц.")
    public void clickChoicePhysPerson(DataEntryAppeals dataEntryAppeals) {

        // Клик на имя в форме
        dataEntryAppeals.getShouldHaveSurname().click();
        //Переход в главную вкладку браузера
        switchTo().window(0);

//        Проверка, что форма поиска контактов закрыта.
        dataEntryAppeals.getShouldOpenFormCearchContact().shouldBe(hidden);
//        Проверка, что открыта форма создания обращения.

//        Проверка, что поля «Контактное лицо», «Предприятие» и «Должность» заполнены.
        //*[@id="contact_created_by_name"]
        $(By.id("contact_created_by_name")).shouldNot(empty);
        $(By.id("account_name")).shouldNot(empty);
        $(By.id("position")).shouldNot(empty);

//      Скролл до раздела «Желаемый способ связи»
        dataEntryAppeals.getScrollSectionCommunicationMethod().scrollIntoView(true);
//        Проверка, что в разделе «Желаемый способ связи» отображаются данные,
//                связанного с выбранным контактом лидом (поля является недоступными для редактирования).
        $(By.id("lk_lastname")).shouldHave(Condition.
                value(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getSurname())).shouldBe(disabled);
        $(By.id("lk_email")).shouldHave(Condition.
                value(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getEmail())).shouldBe(disabled);

    }

    @Step("Шаг 9. В разделе «Основная информация» заполнить поле «Категория» - " +
            "нажать на поле «Категория» и выбрать из выпадающего списка значение «Сотрудник ФЦК»")
    public void fillFieldCategory(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле «Категория»
//        $(By.name("category")).click();
//       // $(By.id("category")).click();
//        //Клик на значение «Сотрудник ФЦК»
//        dataEntryAppeals.getWorkerFck().click();
//        // Проверка, что поле «Категория» заполнено необходимым значением.
//        $(By.id("category")).shouldNot(empty);

    }

    @Step("Шаг 10. В разделе «Основная информация» заполнить поле «Подтип» - " +
            "нажать на поле «Подтип» и выбрать из выпадающего списка значение «Приглашение».")
    public void fillFieldSubtype(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле «Категория»
//        $(By.id("subtype")).click();
//        //Клик на значение «Сотрудник ФЦК»
//        dataEntryAppeals.getSubtypeInvitation().click();
//        // Проверка, что поле «Подтип» заполнено необходимым значением.
//        $(By.id("subtype")).shouldNot(empty);

    }

    @Step("Шаг 11. В разделе «Основная информация» заполнить поле «Тема» - " +
            "нажать на поле «Тема» и выбрать из выпадающего списка значение «Мероприятие».")
    public void fillFieldTopic(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле «Тема»
//        $(By.id("subject")).click();
//        //Клик на значение «Мероприятие»
//        dataEntryAppeals.getTopicEvent().click();
//        // Проверка, что поле «Тема» заполнено.
//        $(By.id("subject")).shouldNot(empty);

    }

    @Step("Шаг 12. В разделе «Основная информация» заполнить поле «Подтема» - " +
            "нажать на поле «Подтема» и выбрать из выпадающего списка значение «Другое».")
    public void fillFieldSubject(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле  «Подтема»
        //$(By.id("subsubject")).click();
//        $(By.name("subsubject")).click();
//        //Клик на значение «Другое»
//        //dataEntryAppeals.getSubsubjectOther().click();
//        // Проверка, что поле «Подтема» заполнено.
//        $(By.id("subsubject")).shouldNot(empty);

    }

    @Step("Шаг 13. В поле «Описание» вручную ввести текст – «Текст описания»")
    public void fillFieldDescription(DataEntryAppeals dataEntryAppeals) {

//        // Ввод текста в поле «Описание»
//        dataEntryAppeals.entryBasicInfo(BasicInfo.TEST_DESCRIPTION.getDescript());
//        // Проверка, что поле «Описание» заполнено необходимым значением.
//        $(By.id("tinymce")).shouldHave(Condition.
//                value(BasicInfo.TEST_DESCRIPTION.getDescript()));
//

    }


}
