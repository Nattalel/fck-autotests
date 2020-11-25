package autotests.myTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.createTest.NewPhysicalPerson;
import pages.TK_A8.LogViewport;
import pages.TK_A8.ModuleAdmin;
import pages.TK_A8.SettingConfig;
import pages.createTest.DataEntry;
import pages.createTest.LoginPage;
import utils.User;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

@Log4j
public class NewTestTK_A8 {
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

        openModuleAdministration();
        selectConfigurationSetting();
        clickLogViewport();
        clickSetBreakpoint();
        openNewBrowserTab();
        selectItemAppeal();
        clickCreateAppeal();
        fillFieldContactPerson();
        inputFielfFio();
    }

    @Step("Шаг 1. Открытие модуля «Администрирование».")
    public void openModuleAdministration() {

        ModuleAdmin moduleAdmin = page(ModuleAdmin.class);
        //наводимся в правом верхнем углу на test_auto
        moduleAdmin.getTestAuto().hover();
        //Выбираем поле Администрирование
        moduleAdmin.getFieldAdmin().click();
        //Проверка, что модуль администрирование открыт
        $(By.id("pagecontent")).should(Condition.appear);

    }

    @Step("Шаг 2. В разделе меню «Система» выбрать «Настройка конфигурации».")
    public void selectConfigurationSetting() {

        SettingConfig settingConfig = page(SettingConfig.class);
        //Клик на настройки конфигурации
        settingConfig.getСlickSettingConfig().click();
        //Проверка, что страница с меню модуля «Администрирование» закрыта
        $(By.id("pagecontent")).shouldBe(hidden);
        // Проверка, что открыта форма просмотра «Настройки конфигурации»
        //settingConfig.getShouldOpenPhysPers().shouldBe(visible);

    }

    @Step("Шаг 3. Внизу формы просмотра кликнуть на «Просмотр журнала».")
    public void clickLogViewport() {

        LogViewport logViewport = page(LogViewport.class);
        //Клик на «Просмотр журнала».
        logViewport.getClickViewLog().click();
        //Проверка, что d новой вкладке открывается форма просмотра логов системы.
        //logViewport.getFormViewLog.shouldBe(visible);

    }

    @Step("Шаг 4. Нажать на кнопку «Установить контрольную точку».")
    public void clickSetBreakpoint() {

    }

    @Step("Шаг 5. В другой вкладке браузера открыть тестовый стенд http://fckproject.itfbgroup.ru/fcktest_001/ " +
            "и выбрать закладку модулей «Все».")
    public void openNewBrowserTab() {

    }

    @Step("Шаг 6. Из выпадающего списка выбрать пункт «Обращения».")
    public void selectItemAppeal() {

    }

    @Step("Шаг 7. В меню модуля выбрать пункт «Создать обращение».")
    public void clickCreateAppeal() {

    }

    @Step("Шаг 8. В разделе «Контактная информация» заполнить поле «Контактное лицо»")
    public void fillFieldContactPerson() {

    }

    @Step("Шаг 9. В поле «ФИО» ввести Фамилию физического лица из предусловия.")
    public void inputFielfFio() {

    }

}