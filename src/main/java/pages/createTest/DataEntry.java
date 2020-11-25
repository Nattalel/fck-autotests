package pages.createTest;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.$;

public class DataEntry {

    @Step("Вводим данные - Фамилия, Имя, Отчество")
    public void ContIn(String surname, String name, String middlename) {
        $("#last_name").sendKeys(surname);
        $("#first_name").sendKeys(name);
        $("#second_name").sendKeys(middlename);
    }

    // Заполнение поля «Категория контакта»
    @FindBy(xpath = "//*[@value=\"employee\"]")
    @Getter
    private SelenideElement clickCompanyEmployee;

    // Заполнение поля  «Предприятие»
    @FindBy(xpath = "//*[@class=\"popupBody\"]")
    @Getter
    private SelenideElement shouldFieldCompany;

    @Step("Вводим ИНН")
    public void contInInn(String inn) {
        $("#inn_advanced").sendKeys(inn);
    }

    @FindBy(xpath = "//*[@class=\"oddListRowS1\"]//a")
    @Getter
    private SelenideElement clickSearchCompany;

    //@FindBy(xpath = "//*[@class=\"panel-content\"]")
//    @FindBy(xpath = "//*[@id=\"EditView_tabs\"]")
//    @Getter
//    private SelenideElement shouldCreatePhysPers;

    @Step("Вводим Должность")
    public void basicInfoPosition(String position) {
        $("#position").sendKeys(position);
    }

    @Step("Вводим контактные данные - Телефон, E-mail")
    public void contactData(String phone, String email) {
        $(".phone_number").sendKeys(phone);
        $("#Contacts0emailAddress0").sendKeys(email);
    }

    // Сохранить и выйти
    @FindBy(xpath = "//*[@class=\"button primary\"]")
    @Getter
    private SelenideElement clickSaveAndExit;

    @FindBy(xpath = "//*[@accesskey=\"a\"]")
    @Getter
    private SelenideElement clickSaveAndExitTwo;

    @FindBy(xpath = "//*[@class=\"detail-view\"]")
    @Getter
    private SelenideElement shouldFormPhPerson;

}
