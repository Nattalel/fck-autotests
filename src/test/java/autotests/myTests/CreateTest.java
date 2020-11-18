package autotests.myTests;

import autotests.BaseTest;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.ContactInfo;
import utils.FieldInn;
import utils.User;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.selectedText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

@Log4j
public class CreateTest extends BaseTest {

    @BeforeMethod
    @Step("Выполнение предусловий")
    public void beforeMethod() {
        //авторизация
        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(User.TEST_USER.getUsername(), User.TEST_USER.getPassword());
    }

    @Test(description = "Демонстрационный тест")
    @Description("Проверка появления меню")
    public void exampleTestPageObjectWithParent() {
        log.info("Сообщение для логгера, вместо System.out.println()");

        //тестовый шаг 1
        menuAppearance();
        createPhysicalPerson();
        createNewPhysicalPerson();
        contInformation();
        categotyCont();
        company();
        contInInn();
    }

    @Step("Шаг 1. Проверка появления меню")
    public void menuAppearance() {
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
        physicalPerson.getShouldNotHomePage().shouldNot(Condition.appear);
        // Проверяем, что открыта форма просмотра модуля «Физические лица»
        physicalPerson.getShouldOpenPhysPers().should(Condition.appear);

    }


    @Step("Шаг 3. Создание нового физического лица")
    public void createNewPhysicalPerson() {
        NewPhysicalPerson newPhysicalPerson = page(NewPhysicalPerson.class);
        // Клик на "Создать физическое лицо"
        newPhysicalPerson.getClickCreatePhysPers().click();
        // Проверяем, что открыта форма создания физического лица.
        newPhysicalPerson.getShouldCreatePhysPers().should(Condition.appear);
    }


    @Step("Шаги 4-6. Заполнение полей Имя, Фамилия, Отчество")
    public void contInformation() {
        DataEntry dataEntry = page(DataEntry.class);
        dataEntry.ContIn(ContactInfo.TEST_CONTACTINFO.getSurname(),
                ContactInfo.TEST_CONTACTINFO.getName(),
                        ContactInfo.TEST_CONTACTINFO.getMiddlename());
    }


    @Step("Шаг 7. Заполнение поля «Категория контакта»")
    public void categotyCont() {
        EntryCategoreCont entryCategoreCont = page(EntryCategoreCont.class);
        // Кликаем на выпадающий список в разделе "Категория контакта"
        entryCategoreCont.getClickCategoreCont().click();
        // Выбираем "Сотрудник предприятия"
        entryCategoreCont.getClickCompanyEmployee().click();

        //проверяем, что поле «Категория контакта» заполнено необходимым значениемd
        entryCategoreCont.getShouldCategoreCont().shouldHave(text("Сотрудник предприятия"));
    }


    @Step("Шаг 8. Заполнение поля  «Предприятие»")
    public void company() {

        FieldCompany fieldCompany = page(FieldCompany.class);
        // Кликаем на стрелочку
        fieldCompany.getClickFieldCompany().click();

        // Переход в окно открывшейся вкладки
        switchTo().window(1);

        //Проверяем, что открыта форма поиска предприятия.
        fieldCompany.getShouldFieldCompany().should(Condition.appear);
    }

    @Step("Шаги 9-11. Заполняем инн,нажимаем поиск и выбираем найденное предприятие")
    public void contInInn() {

        EntryInn entryInn = page(EntryInn.class);

        // Заполняем ИНН
        entryInn.ContInInn(FieldInn.TEST_FIELDINN.getInn());

        // Кликаем на кнопку "Найти"
        entryInn.getClickSearch().click();

        // Проверяем, что открыта форма просмотра списка предприятий с одним предприятием.
        //entryInn.getShouldSize().shouldHave(size(1));
        $$(".list>tbody tr").shouldHave(size(1));

        //Клик на найденное предприятие
        entryInn.getClickSearchCompany().click();

        // Проверяем, что форма просмотра списка предприятий закрыта.
        entryInn.getShouldFieldCompany().shouldNot(Condition.appear);

        // Проверяем, что открыта форма создания физического лица.
        entryInn.getShouldCreatePhysPers().should(Condition.appear);

        // Проверяем, что поле «Предприятие» заполнено значением, выбранным из списка предприятий.

        //$("input").shouldHave(selectedText("Text"));
    }








}