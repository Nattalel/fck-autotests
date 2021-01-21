package pages.TK_A4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.$;

public class DataEntryAppeals {

    // Проверка, что открыта форма поиска контактов.
    @FindBy(xpath = "//*[@class=\"popupBody\"]")
    @Getter
    private SelenideElement shouldOpenFormCearchContact;

    // имя в форме
    @FindBy(xpath = "//*[@class=\"oddListRowS1\"]//a")
    @Getter
    private SelenideElement shouldHaveSurname;

    // Email
    @FindBy(xpath = "(//*[@class=\"oddListRowS1\"]//td)[5]")
    @Getter
    private SelenideElement shouldHaveEmail;

    // Скролл до раздела «Желаемый способ связи»
    @FindBy(xpath = "(//*[@class=\"panel panel-default\"])[3]")
    @Getter
    private SelenideElement scrollSectionCommunicationMethod;

    //Клик на значение «Сотрудник ФЦК»
    @FindBy(xpath = "//*[@value=\"fck\"]")
    @Getter
    private SelenideElement workerFck;

    //Клик на значение «Приглашение»
    @FindBy(xpath = "//*[@value=\"invitation\"]")
    @Getter
    private SelenideElement subtypeInvitation;

    //Клик на значение «Мероприятие»
    @FindBy(xpath = "//*[@value=\"invitation_events\"]")
    @Getter
    private SelenideElement topicEvent;

//    //Клик на значение «Другое»
//    @FindBy(xpath = "//*[@value=\"invitation_events_other\"]")
//    @Getter
//    private SelenideElement subsubjectOther;

    //Клик на значение «Другое»
    @FindBy(xpath = "//*[@value=\"consult_fck_other\"]")
    @Getter
    private SelenideElement subsubjectOther;

    // Скролл до раздела «Основная информация»
    @FindBy(xpath = "(//*[@class=\"panel panel-default\"])[2]")
    @Getter
    private SelenideElement scrollDasicInfo;

    // Клик на поле «Категория»
    @FindBy(name = "category")
    @Getter
    private SelenideElement fieldCategory;

    //Желаемый способ связи
    @FindBy(xpath = "(//*[@class=\"panel panel-default\"])[3]")
    @Getter
    private SelenideElement scrollWishfulCommunicationMethod;

    @FindBy(xpath = "(//*[@class=\"panel panel-default\"])[3]")
    @Getter
    private SelenideElement wishfulCommunicationMethod;

    @FindBy(xpath = "//*[@id=\"connect\"]//option")
    @Getter
    private SelenideElement shouldWishfulCommunicationMethod;

    //Email
    @FindBy(xpath = "(//*[@value=\"email\"])[2]")
    @Getter
    private SelenideElement choiceEmail;

    //Email для связи
    @FindBy(xpath = "(//*[@data-label=\"LBL_CONTACT_EMAILS\"])[2]")
    @Getter
    private SelenideElement shouldEmailContact;

    //выбор в Email "другое"
    @FindBy(xpath = "(//*[@value=\"other\"])[3]")
    @Getter
    private SelenideElement emailOther;

    //Клик "Сохраить и выйти"
    @FindBy(xpath = "(//*[@class=\"button primary\"])[2]")
    @Getter
    private SelenideElement buttonSaveAndExit;

    // Для задачи 6

    //Клик на значение «Консультации»
    @FindBy(xpath = "//*[@value=\"consult\"]")
    @Getter
    private SelenideElement subtypeConsult;

    //Клик на значение «Работник фск»
    @FindBy(xpath = "//*[@value=\"consult_fck\"]")
    @Getter
    private SelenideElement consultFck;

    @Step("Вводим данные - Фамилия")
    public void ContInSurname(String surname) {
        $("#full_name_advanced").sendKeys(surname);
    }
    @Step("Вводим данные - email")
    public void ContInEmail(String email) {
        $("#email_advanced").sendKeys(email);
    }
    @Step("Ввод текста в поле «Описание»")
    public void entryBasicInfo(String descript) { $("#tinymce").sendKeys(descript); }
    @Step("В поле «Email для связи» выбрать Email из предусловия")
    public void ContInEmailForConnect(String email) { $("#other_email").sendKeys(email); }
















}
