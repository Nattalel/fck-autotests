package autotests.myTests;

import autotests.BaseTest;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TK_A4.*;
import pages.createTest.LoginPage;
import pages.MainPage;
import utils.BasicInfo;
import utils.ContactInfoAppeals;
import utils.User;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class TestTK_A4 extends BaseTest {

    @BeforeMethod
    @Step("Выполнение предусловий")
    public void beforeMethod() {
        //авторизация
        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(User.TEST_USER.getUsername(), User.TEST_USER.getPassword());
    }

    @Test(description = "Тест - Создание обращения от ФЛ с ЛК")
    @Description("Создание обращения от ФЛ с ЛК")
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
        fillFieldCategory(dataEntryAppeals);
        fillFieldSubtype(dataEntryAppeals);
        fillFieldTopic(dataEntryAppeals);
        fillFieldSubject(dataEntryAppeals);
        fillFieldDescription(dataEntryAppeals);
        clickWishfulCommunicationMethod(dataEntryAppeals);
        clickButtonSaveAndExit(dataEntryAppeals);
        String caseNumber = $(By.id("case_number")).getText();
        checkDeadlineProcessing(caseNumber);
        shouldPriorityWeight();
        shouldStatusWeight(caseNumber);
        shouldStateWeight();

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

    }

    @Step("Шаг 4. В разделе «Контактная информация» заполнить поле «Контактное лицо»")
    public void clickDataEntryAppeals(DataEntryAppeals dataEntryAppeals) {

        //Клик на стрелочку у поля «Контактная информация»
        $(By.id("btn_contact_created_by_name")).click();
        //Переход в другую вкладку браузера
        switchTo().window(1);
        // Проверка, что открыта форма поиска контактов.
        dataEntryAppeals.getShouldOpenFormCearchContact().shouldBe(visible);

    }

    @Step("Шаг 5. В поле «ФИО» ввести фамилию физического лица из предусловия.")
    public void entrySurname(DataEntryAppeals dataEntryAppeals) {

        dataEntryAppeals.ContInSurname(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getSurname());

    }

    @Step("Шаг 6. В поле «Любой E-mail» ввести E-mail физического лица из предусловия.")
    public void entryEmail(DataEntryAppeals dataEntryAppeals) {

        dataEntryAppeals.ContInEmail(ContactInfoAppeals.TEST_CONTACTINFOAPPEALS.getEmail());

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

    @Step("Шаг 9. В разделе «Основная информация» заполнить поле «Категория» - " +
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

    @Step("Шаг 10. В разделе «Основная информация» заполнить поле «Подтип» - " +
            "нажать на поле «Подтип» и выбрать из выпадающего списка значение «Приглашение».")
    public void fillFieldSubtype(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле «Категория»
        $(By.id("subtype")).click();
        //Клик на значение «Сотрудник ФЦК»
        dataEntryAppeals.getSubtypeInvitation().click();
        // Проверка, что поле «Подтип» заполнено необходимым значением.
        $(By.id("subtype")).shouldNot(empty);

    }

    @Step("Шаг 11. В разделе «Основная информация» заполнить поле «Тема» - " +
            "нажать на поле «Тема» и выбрать из выпадающего списка значение «Мероприятие».")
    public void fillFieldTopic(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле «Тема»
        $(By.id("subject")).click();
        //Клик на значение «Мероприятие»
        dataEntryAppeals.getTopicEvent().click();
        // Проверка, что поле «Тема» заполнено.
        $(By.id("subject")).shouldNot(empty);

    }

    @Step("Шаг 12. В разделе «Основная информация» заполнить поле «Подтема» - " +
            "нажать на поле «Подтема» и выбрать из выпадающего списка значение «Другое».")
    public void fillFieldSubject(DataEntryAppeals dataEntryAppeals) {

        // Клик на поле  «Подтема»
        $(By.id("subsubject")).click();
        //Клик на значение «Другое»
        dataEntryAppeals.getSubsubjectOther().click();
        // Проверка, что поле «Подтема» заполнено.
        $(By.id("subsubject")).shouldNot(empty);

    }

    @Step("Шаг 13. В поле «Описание» вручную ввести текст – «Текст описания»")
    public void fillFieldDescription(DataEntryAppeals dataEntryAppeals) {

        switchTo().frame(2);
        // Ввод текста в поле «Описание»
        dataEntryAppeals.entryBasicInfo(BasicInfo.TEST_DESCRIPTION.getDescript());
        // Проверка, что поле «Описание» заполнено необходимым значением.
        $(By.id("tinymce")).shouldHave(Condition.
                text(BasicInfo.TEST_DESCRIPTION.getDescript()));
        switchTo().window(0);

    }

    @Step("Шаги 14 - 16. нажать на поле «Желаемый способ связи», заполнить Email")
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

    @Step("Шаг 17. Нажать на кнопку «Сохранить и выйти»")
    public void clickButtonSaveAndExit(DataEntryAppeals dataEntryAppeals) {

        // Клик накнопку «Сохранить и выйти»
        dataEntryAppeals.getButtonSaveAndExit().click();

    }

    @Step("Шаг 18. Проверить заполнение поля «Крайний срок обработки».")
    public void checkDeadlineProcessing(String caseNumber) {

        CheckField checkField = page(CheckField.class);
        LocalDateTime today = LocalDateTime.now();

        String field = $(By.xpath("//*[@field=\"channel\"]")).getText() + " > " +
                $(By.xpath("//*[@field=\"subtype\"]")).getText() + " > " +
                $(By.xpath("//*[@field=\"subject\"]")).getText();

        //наводимся на вкладку "Все"
        checkField.getAllTab().hover();
        // проверяем, что выпадающее меню-список отображается
        checkField.getAllDropdown().should(appear);
        //Клик на пункт "Администрирование обращений"
        checkField.getAdminAppeals().scrollIntoView(true).click();
        // Клик на обращение
        $$(By.xpath("//*[@field=\"name\"]//a")).findBy(exactText(field)).click();
        //Получаем число дней интервала обработки
        int processingInterval = Integer.parseInt($(By.xpath("//*[@field=\"processing_time\"]")).getText());

        // Наводим на вкладку "Все"
        checkField.getAllTab().hover();
        // Клик на пункт "Производственный календарь"
        $$(By.xpath("//*[@class=\"topnav all\"]//*[@class=\"dropdown-menu\"]//a"))
                .findBy(exactText("Производственный календарь")).click();
        // Получаем коллекцию дат из производственного календаря
        List<String> productionCalendar = $$(By.xpath("//*[@field=\"festive_date\"]")).texts();

        // Поиск нужного обращения
        searchWeightMethod(caseNumber);

        // Проверяем, что текущий день не выходной и не праздник
        // Если выходной или праздник, проверяем след день
        while (productionCalendar.contains(today)
                || today.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            today = today.plusDays(1);
        }
        //Прибавляем к текущему дню интервал обработки
        today = today.plusDays(processingInterval);
        //Проверяем, является ли следующий день выходным или праздником
        while (productionCalendar.contains(today)
                || today.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || today.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            today = today.plusDays(1);
        }

        String dateInString = $(By.id("processing_deadline")).getText();
        String deadlineProcessing = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        //Проверка,что даты совпадают
        assertEquals(dateInString, deadlineProcessing);

    }

    @Step("Шаг 19. Проверить заполнение поля «Вес обращения».")
    public void shouldPriorityWeight() {

        PriorityWeight priorityWeight = page(PriorityWeight.class);

        //Получаем вес обращения
        int weight = Integer.parseInt($(By.id("weight")).getText());

        String field = $(By.xpath("//*[@field=\"channel\"]")).getText() + " > " +
                $(By.xpath("//*[@field=\"subtype\"]")).getText() + " > " +
                $(By.xpath("//*[@field=\"subject\"]")).getText();

        //наводимся на вкладку "Все"
        priorityWeight.getAllTab().hover();
        // проверяем, что выпадающее меню-список отображается
        priorityWeight.getAllDropdown().should(appear);
        //Клик на пункт "Администрирование обращений"
        priorityWeight.getAdminAppeals().scrollIntoView(true).click();
        $$(By.xpath("//*[@field=\"name\"]//a")).findBy(exactText(field)).click();
        //Получаем базовый вес обращения
        int basicWeight = Integer.parseInt($(By.xpath("//*[@field=\"case_weight\"]")).getText());
        //Получаем приоритет
        String casePriority = $(By.xpath("//*[@field=\"case_priority\"]")).getText();

        if (casePriority.equals("Высокий")) {
            basicWeight = basicWeight + 3;
        } else if (casePriority.equals("Средний")) {
            basicWeight = basicWeight + 2;
        } else if (casePriority.equals("Низкий")) {
            basicWeight = basicWeight + 1;
        }

        //Проверка,что вес обращений совпадает
        assertEquals(basicWeight, weight);

    }

    @Step("Шаг 20. Проверить статус обращения.")
    public void shouldStatusWeight(String caseNumber) {

        //Находим нужное обращение
        searchWeightMethod(caseNumber);
        //Проверка,что статус обращений совпадает
        $(By.xpath("//*[@field=\"status\"]")).should(Condition.text("Не назначено"));

    }

    @Step("Шаг 21. Проверить состояние обращения.")
    public void shouldStateWeight() {

        //Проверка,что статус обращений совпадает
        $(By.xpath("//*[@field=\"state\"]")).should(Condition.text("Открыто"));

    }

    @Step("Поиск нужного обращения")
    public void searchWeightMethod(String caseNumber) {

        SearchWeight searchWeight = page(SearchWeight.class);

        //наводимся на вкладку "Все"
        searchWeight.getAllTab().hover();
        //проверяем, что выпадающее меню-список отображается
        searchWeight.getAllDropdown().should(Condition.appear);
        //Клик на пункт "Обращения"
        searchWeight.getClickAppeals().scrollIntoView(true).click();
        // Проверка, что открыт модуль «Обращения» («Cases»).
        searchWeight.getShouldAppeals().should(Condition.appear);
        //Клик на фильтрацию записей
        searchWeight.getСlickFilter().click();
        //Ввод номера обращения
        $(By.id("case_number_advanced")).clear();
        $(By.id("case_number_advanced")).sendKeys(caseNumber);
        // Клик на поиск
        $(By.id("search_form_submit_advanced")).scrollIntoView(true).click();
        //Клик на найденное обращение
        $(By.xpath("//*[@field=\"name\"]//a")).click();

    }


}
