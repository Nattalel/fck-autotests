package autotests.myTests;

import autotests.BaseTest;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TK_A4.Appeals;
import pages.TK_A4.CreateAppeals;
import pages.TK_A4.DataEntryAppeals;
import pages.ModuleAdmin;
import pages.LogViewport;
import pages.SettingConfig;
import pages.TK_A6.AssignUserName;
import pages.TK_A6.DatebaseFck;
import pages.TK_A6.LoginSiteSubd;
import pages.createTest.LoginPage;
import utils.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestTK_A6 extends BaseTest {

    @BeforeMethod
    @Step("Выполнение предусловий")
    public void beforeMethod() {
        //авторизация
        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(User.TEST_USER.getUsername(), User.TEST_USER.getPassword());
    }

    @Test(description = "Тест - Назначение ответственного по обращению")
    @Description("Назначение ответственного по обращению")
    public void exampleTestPageObjectWithParent() {

        DataEntryAppeals dataEntryAppeals = page(DataEntryAppeals.class);
        DatebaseFck datebaseFck = page(DatebaseFck.class);

//        openModuleAdministration();
//        selectConfigurationSetting();
//        clickLogViewport();
//        clickSetBreakpoint();
//        openNewBrowserTab();
//        selectItemAppeal();
//        clickCreateAppeal();
//        fillFieldContactPerson(dataEntryAppeals);
//        inputFielfFio(dataEntryAppeals);
//        clickSearch(dataEntryAppeals);
//        clickChoicePhysPerson(dataEntryAppeals);
//        fillFieldCategory(dataEntryAppeals);
//        fillFieldSubtype(dataEntryAppeals);
//        fillFieldType(dataEntryAppeals);
//        fillFieldSubject(dataEntryAppeals);
//        fillFieldDescription(dataEntryAppeals);
//        clickWishfulCommunicationMethod(dataEntryAppeals);
//        clickButtonSaveAndExit(dataEntryAppeals);
//        clickButtonAssignUserName();
        inputSiteSubd();
        selectDb(datebaseFck);
        clickButtonSql(datebaseFck);
        enterRequestSql(datebaseFck);

    }

    @Step("Шаг 1. Открытие модуля «Администрирование»")
    public void openModuleAdministration() {

        ModuleAdmin moduleAdmin = page(ModuleAdmin.class);
        //наводимся в правом верхнем углу на test_auto
        moduleAdmin.getTestAuto().hover();
        //Выбираем поле Администрирование
        moduleAdmin.getFieldAdmin().click();
        //Проверка, что модуль администрирование открыт
        moduleAdmin.getShouldfieldAdmin().shouldHave(text("Администрирование"));

    }

    @Step("Шаг 2. В разделе меню «Система» выбрать «Настройка конфигурации».")
    public void selectConfigurationSetting() {

        SettingConfig settingConfig = page(SettingConfig.class);
        //Клик на настройки конфигурации
        settingConfig.getСlickSettingConfig().click();
        //Проверка, что страница с меню модуля «Администрирование» закрыта
        settingConfig.getShouldfieldAdmin().shouldNotHave(text("Администрирование"));
        // Проверка, что открыта форма просмотра «Настройки конфигурации»
        settingConfig.getShouldOpenPhysPers().shouldHave(text("Настройка конфигурации"));

    }

    @Step("Шаг 3. Внизу формы просмотра кликнуть на «Просмотр журнала».")
    public void clickLogViewport() {

        LogViewport logViewport = page(LogViewport.class);
        //Клик на «Просмотр журнала».
        logViewport.getClickViewLog().scrollIntoView(true).click();
        //Проверка, что в новой вкладке открывается форма просмотра логов системы.
        //logViewport.getFormViewLog.shouldBe(visible);

    }

    @Step("Шаг 4. Нажать на кнопку «Установить контрольную точку».")
    public void clickSetBreakpoint() {

        switchTo().window(1);
        //Клик на кнопку «Установить контрольную точку»
        $(By.name("mark")).click();
        // Проверка, что отображается сообщение «Контрольная точка в журнале установлена»
        $(By.xpath("//*[@id=\"pagecontent\"]/h3")).shouldHave(text("Контрольная точка в журнале установлена"));

    }

    @Step("Шаг 5. В другой вкладке браузера открыть тестовый стенд и выбрать закладку модулей «Все»")
    public void openNewBrowserTab() {

        switchTo().window(0);

        open("http://fckproject.itfbgroup.ru/auto/");

        MainPage mainPage = page(MainPage.class);
        //наводимся на вкладку "Все"
        mainPage.getAllTab().hover();
        //проверяем, что выпадающее меню-список отображается
        mainPage.getAllDropdown().should(Condition.appear);

    }

    @Step("Шаг 6. Из выпадающего списка выбрать пункт «Обращения».")
    public void selectItemAppeal() {

        Appeals appears = page(Appeals.class);
        //Клик на пункт "Обращения"
        appears.getClickAppeals().scrollIntoView(true).click();
        // Проверка, что открыт модуль «Обращения» («Cases»).
        appears.getShouldAppeals().should(Condition.appear);

    }

    @Step("Шаг 7. В меню модуля выбрать пункт «Создать обращение».")
    public void clickCreateAppeal() {

        CreateAppeals createAppeals = page(CreateAppeals.class);
        //Клик на пункт «Создать обращение»
        createAppeals.getClickCreateAppeals().click();

    }

    @Step("Шаг 8. В разделе «Контактная информация» заполнить поле «Контактное лицо»")
    public void fillFieldContactPerson(DataEntryAppeals dataEntryAppeals) {

        //Клик на стрелочку у поля «Контактная информация»
        $(By.id("btn_contact_created_by_name")).click();
        //Переход в другую вкладку браузера
        switchTo().window(2);
        // Проверка, что открыта форма поиска контактов.
        //dataEntryAppeals.getShouldOpenFormCearchContact().shouldBe(visible);

    }

    @Step("Шаг 9. В поле «ФИО» ввести Фамилию физического лица из предусловия.")
    public void inputFielfFio(DataEntryAppeals dataEntryAppeals) {

        dataEntryAppeals.ContInSurname(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getSurname());
        dataEntryAppeals.ContInEmail(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getEmail());

    }

    @Step("Шаг 10. Нажать на кнопку «Найти»")
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

    @Step("Шаг 11. Выбрать физическое лицо из формы просмотра списка физических лиц")
    public void clickChoicePhysPerson(DataEntryAppeals dataEntryAppeals) {

        // Клик на имя в форме
        dataEntryAppeals.getShouldHaveSurname().click();
        //Переход в главную вкладку браузера
        switchTo().window(0);

//        Проверка, что форма поиска контактов закрыта.
        dataEntryAppeals.getShouldOpenFormCearchContact().shouldBe(hidden);

//        Проверка, что поля «Контактное лицо», «Предприятие» и «Должность» заполнены.
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

    @Step("Шаг 12. В подменю «Основная информация» заполнить поле «Категория» - " +
            "нажать на поле «Категория» и выбрать из выпадающего списка значение «Сотрудник ФЦК»")
    public void fillFieldCategory(DataEntryAppeals dataEntryAppeals) {

        // Скролл до раздела «Основная информация»
        dataEntryAppeals.getScrollDasicInfo().scrollIntoView(true);
        // Клик на поле «Категория»
        dataEntryAppeals.getFieldCategory().click();
        //Клик на значение «Сотрудник ФЦК»
        dataEntryAppeals.getWorkerFck().click();
        // Проверка, что поле «Категория» заполнено необходимым значением.
        $(By.id("category")).shouldNot(empty);

    }

    @Step("Шаг 13. В разделе «Основная информация» заполнить поле «Подтип» - " +
            "нажать на поле «Подтип» и выбрать из выпадающего списка значение «Приглашение».")
    public void fillFieldSubtype(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле «Подтип»
        $(By.id("subtype")).click();
        //Клик на значение «Консультации»
        dataEntryAppeals.getSubtypeConsult().click();
        // Проверка, что поле «Подтип» заполнено необходимым значением.
        $(By.id("subtype")).shouldNot(empty);

    }

    @Step("Шаг 14. В подменю «Основная информация» заполнить поле «Тема» - " +
            "нажать на поле «Тема» и выбрать из выпадающего списка значение «Работа ФЦК».")
    public void fillFieldType(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле «Тема»
        $(By.id("subject")).click();
        //Клик на значение «Работа ФЦК»
        dataEntryAppeals.getConsultFck().click();
        // Проверка, что поле «Тема» заполнено.
        $(By.id("subject")).shouldNot(empty);

    }

    @Step("Шаг 15. В подменю «Основная информация» заполнить поле «Подтема» - " +
            "нажать на поле «Подтема» и выбрать из выпадающего списка значение «Другое».")
    public void fillFieldSubject(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле  «Подтема»
        $(By.id("subsubject")).click();
        //Клик на значение «Другое»
        ////
        dataEntryAppeals.getSubsubjectOther().click();
        // Проверка, что поле «Подтема» заполнено.
        $(By.id("subsubject")).shouldNot(empty);

    }

    @Step("Шаг 16. В поле «Описание» вручную ввести текст – «Текст описания»")
    public void fillFieldDescription(DataEntryAppeals dataEntryAppeals) {

        switchTo().frame(2);
        // Ввод текста в поле «Описание»
        dataEntryAppeals.entryBasicInfo(BasicInfo.TEST_DESCRIPTION.getDescript());
        // Проверка, что поле «Описание» заполнено необходимым значением.
        $(By.id("tinymce")).shouldHave(Condition.
                text(BasicInfo.TEST_DESCRIPTION.getDescript()));
        switchTo().window(0);

    }

    @Step("Шаги 17 - 19. нажать на поле «Желаемый способ связи», заполнить Email")
    public void clickWishfulCommunicationMethod(DataEntryAppeals dataEntryAppeals) {

        // Скролл до раздела «Желаемый способ связи»
        dataEntryAppeals.getScrollWishfulCommunicationMethod().scrollIntoView(true);
        // Клик на поле «Желаемый способ связи»
        $(By.id("connect")).click();
        // Проверка, что открыт выпадающий список поля «Желаемый способ связи».
        dataEntryAppeals.getShouldWishfulCommunicationMethod().should(Condition.visible);
        //Из выпадающего списка выбрать «Email».
        dataEntryAppeals.getChoiceEmail().click();
        // Появилось поле «Email для связи»
        dataEntryAppeals.getShouldEmailContact().shouldBe(visible);
        //В поле «Email для связи» выбрать Email из предусловия.
        dataEntryAppeals.getShouldEmailContact().click();
        dataEntryAppeals.getEmailOther().click();
        dataEntryAppeals.ContInEmailForConnect(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getEmail());
        //Поле «Email для связи» заполнено.
        dataEntryAppeals.getShouldEmailContact().shouldNot(empty);

    }

    @Step("Шаг 20. Нажать на кнопку «Сохранить и выйти»")
    public void clickButtonSaveAndExit(DataEntryAppeals dataEntryAppeals) {

        // Клик накнопку «Сохранить и выйти»
        dataEntryAppeals.getButtonSaveAndExit().click();

//        Закрыта форма создания обращения.
        $(By.xpath("//*[@class=\"module-title-text\"]")).shouldNotHave(text("Создать"));
//        Открыта форма просмотра обращения.
        $(By.xpath("//*[@class=\"module-title-text\"]")).shouldHave(text("Работа ФЦК"));
//        Поле «Состояние» («state») заполнено – «Открыто» («Open»).
        $(By.xpath("//*[@field=\"state\"]")).should(Condition.text("Открыто"));
//        Поле «Статус» («status») –«Не назначено» («Dont_Assigned»).
        $(By.xpath("//*[@field=\"status\"]")).should(Condition.text("Не назначено"));
//        Поле «Ответственный(ая)» («assigned_user_name») пустое.
        $(By.xpath("//*[@field=\"assigned_user_name\"]")).should(empty);

    }

    @Step("Шаг 21. В форме просмотра обращения нажать на кнопку «Назначить ответственного».")
    public void clickButtonAssignUserName() {

        AssignUserName assignUserName = page(AssignUserName.class);

        // Клик на кнопку «Назначить ответственного»
        assignUserName.getClickAssignUserName().click();
        // Проверка, что открыто окно поиска сотрудников, доступных для назначения.

    }

    @Step("Шаг 22. Перейти на сайт СУБД из предусловия.")
    public void inputSiteSubd() {

        open("http://192.168.30.111/phpmyadmin/");

        LoginSiteSubd loginSiteSubd = page(LoginSiteSubd.class);
        loginSiteSubd.logInSite(SiteDb.TEST_SITEDB.getUsernameInput(), SiteDb.TEST_SITEDB.getPasswordInput());
        // Клик на кнопке "Вперед
        $(By.id("input_go")).click();

        // Проверка, что открыта главная страница СУБД.

    }

    @Step("Шаг 23. На боковой панели выбрать БД «db_fcktestwo»")
    public void selectDb(DatebaseFck datebaseFck) {

        //switchTo().window(4);
        //На боковой панели выбрать БД «db_fcktestwo»
        datebaseFck.getDbAuto().click();

        // Проверка, что открыт список таблиц выбранной БД.
        //datebaseFck.getListTableDb().

    }

    @Step("Шаг 24. На основной панели нажать на кнопку «SQL»")
    public void clickButtonSql(DatebaseFck datebaseFck) {

        // На основной панели нажать на кнопку «SQL».
        $$(By.xpath("//*[@id=\"floating_menubar\"]//li"))
                .findBy(exactText("SQL")).click();
        //datebaseFck.getClickSql().click();
        // Проверка, что открыта страница с формой для ввода запроса.
        datebaseFck.getOpenFormSql().should(Condition.visible);


    }

    @Step("Шаг 25. Ввод запроса")
    public void enterRequestSql(DatebaseFck datebaseFck) {

        //клик на консоль  //*[@class="toolbar collapsed"]
        $(By.xpath("//*[@class=\"toolbar collapsed\"]")).click();
        //datebaseFck.click();
        $(By.xpath("((//*[@class=\"CodeMirror-code\"])//span)[1]")).sendKeys("select t from re");
        //ввод запроса
        //datebaseFck.SqlRequest(RequestSql.TEST_REQUESTSQL.getSql());
        // Нажать на кнопку "Вперед"
        $(By.id("button_submit_query")).click();
        // Проверка, что в результате указан id «3947f96e-9642-954f-18e0-5f74540d8ea9».
        $(By.xpath("//*[@class=\"odd\"]//span")).should(Condition.text("3947f96e-9642-954f-18e0-5f74540d8ea9"));
    }










}
