package autotests.myTests;

import autotests.BaseTest;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.createTest.*;
import utils.ContactData;
import utils.ContactInfo;
import utils.User;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

@Log4j
public class CreateTest extends BaseTest {

    private String firstName;
    private String lastName;
    private String secondName;
    private String category;
    private String company;
    private String position;
    private String phone;
    private String mail;

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

        NewPhysicalPerson newPhysicalPerson = page(NewPhysicalPerson.class);
        DataEntry dataEntry = page(DataEntry.class);

        checkAppearanceMenu();
        createPhysicalPerson();
        createNewPhysicalPerson(newPhysicalPerson);
        entryFieldFio(dataEntry);
        entryFieldCategotyCont(dataEntry);
        entryFieldCompany(dataEntry);
        entryFieldInn(dataEntry);
        entryFieldPosition(dataEntry);
        entryContsctData(dataEntry);
        clickSaveAndExit(dataEntry);
        checkEnterValues();

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

    @Step("Шаг 2. Создание физического лица")
    public void createPhysicalPerson() {

        PhysicalPerson physicalPerson = page(PhysicalPerson.class);

        // Клик на пункт «Физические лица»
        physicalPerson.getClickPhysPers().click();
        // Проверяем, что домашняя страница закрыта
        physicalPerson.getShouldNotHomePage().shouldBe(hidden);
        // Проверяем, что открыта форма просмотра модуля «Физические лица»
        physicalPerson.getShouldOpenPhysPers().shouldBe(visible);

    }

    @Step("Шаг 3. Создание нового физического лица")
    public void createNewPhysicalPerson(NewPhysicalPerson newPhysicalPerson) {

        // Клик на "Создать физическое лицо"
        newPhysicalPerson.getClickCreatePhysPers().click();
        // Проверяем, что открыта форма создания физического лица.
        newPhysicalPerson.getShouldCreatePhysPers().shouldBe(visible);

    }

    @Step("Шаги 4-6. Заполнение полей Имя, Фамилия, Отчество")
    public void entryFieldFio(DataEntry dataEntry) {

        dataEntry.ContIn(ContactInfo.TEST_CONTACTINFO.getSurname(),
                ContactInfo.TEST_CONTACTINFO.getName(),
                ContactInfo.TEST_CONTACTINFO.getMiddlename());

        //Получаем введенные значения ФИО
        firstName = $(By.id("first_name")).getValue();
        lastName = $(By.id("last_name")).getValue();
        secondName = $(By.id("second_name")).getValue();

    }

    @Step("Шаг 7. Заполнение поля «Категория контакта»")
    public void entryFieldCategotyCont(DataEntry dataEntry) {

        // Кликаем на выпадающий список в разделе "Категория контакта"
        $(By.name("contact_category")).click();
        // Выбираем "Сотрудник предприятия"
        dataEntry.getClickCompanyEmployee().click();
        //проверяем, что поле «Категория контакта» заполнено необходимым значением
        $(By.name("contact_category")).shouldHave(text("Сотрудник предприятия"));
        // Получаем введенное значение категории контакта
        category = $(By.name("contact_category")).text();

    }

    @Step("Шаг 8. Заполнение поля  «Предприятие»")
    public void entryFieldCompany(DataEntry dataEntry) {

        // Кликаем на стрелочку
        $(By.name("btn_account_name")).click();
        // Переход в окно открывшейся вкладки
        switchTo().window(1);
        //Проверяем, что открыта форма поиска предприятия.
        dataEntry.getShouldFieldCompany().shouldBe(visible);

    }

    @Step("Шаги 9-11. Заполняем инн,нажимаем поиск и выбираем найденное предприятие")
    public void entryFieldInn(DataEntry dataEntry) {

        // Заполняем ИНН
        dataEntry.contInInn(ContactInfo.TEST_CONTACTINFO.getInn());
        // Кликаем на кнопку "Найти"
        $(By.id("search_form_submit")).click();
        // Проверяем, что открыта форма просмотра списка предприятий с одним предприятием.
        $$(".list>tbody tr").shouldHave(size(1));
        // Получаем название предприятия
        String fieldCompany = $(By.xpath("//*[@class=\"oddListRowS1\"]//a")).getText();
        //Клик на найденное предприятие
        dataEntry.getClickSearchCompany().click();
        // Переход в главное окно
        switchTo().window(0);
        // Проверяем, что форма просмотра списка предприятий закрыта.
        dataEntry.getShouldFieldCompany().shouldBe(hidden);
        // Проверяем, что открыта форма создания физического лица.
        $(By.id("EditView_tabs")).shouldBe(visible);
        // Проверяем, что поле «Предприятие» заполнено значением, выбранным из списка предприятий.
        $(By.name("account_name")).shouldHave(exactValue(fieldCompany));
        // Получаем введенное значение предприятия
        company = $(By.id("account_name")).val();

    }

    @Step("Шаг 12. Заполнение поля Должность")
    public void entryFieldPosition(DataEntry dataEntry) {
        dataEntry.basicInfoPosition(ContactInfo.TEST_CONTACTINFO.getPosition());
        // Получаем введенное значение должности
        position = $(By.id("position")).val();
    }

    @Step("Шаг 13-14. Заполнение Контактных данных (Телефон и E-mail")
    public void entryContsctData(DataEntry dataEntry) {
        dataEntry.contactData(ContactData.TEST_CONTACTDATA.getPhone(),
                ContactData.TEST_CONTACTDATA.getEmail());
        phone = $(By.xpath("//*[@type=\"phone\"]")).val();
        mail = $(By.id("Contacts0emailAddress0")).val();
    }

    @Step("Шаг 15. Нажатие на кнопку «Сохранить и выйти»")
    public void clickSaveAndExit(DataEntry dataEntry) {
        // Клик на кнопку "Сохранить и выйти"
        dataEntry.getClickSaveAndExit().click();
        dataEntry.getClickSaveAndExitTwo().click();
        // Проверяем, что форма создания физического лица закрыта.
        $(By.id("EditView_tabs")).shouldBe(hidden);
        // Проверяем, что открыта форма просмотра физического лица.
        dataEntry.getShouldFormPhPerson().shouldBe(visible);
    }

    @Step("Шаг 16. Проверка введенных значений")
    public void checkEnterValues() {

        EnterValues enterValues = page(EnterValues.class);

        // Проверка фамилии
        $(By.id("last_name")).shouldHave(text(lastName));
        // Проверка имени
        $(By.id("first_name")).shouldHave(text(firstName));
        // Проверка отчества
        $(By.id("second_name")).shouldHave(text(secondName));
        // Проверка категории контакта
        enterValues.getShouldCotegoryCont().shouldHave(text(category));
        // Проверка предприятия
        $(By.id("account_id")).shouldHave(text(company));
        // Проверка должности
        $(By.id("position_id")).shouldHave(text(position));
        // Проверка телефона
        enterValues.getShouldPhone().shouldHave(text(phone));
        // Проверка Email
        enterValues.getShouldEmail().shouldHave(text(mail));

    }
}