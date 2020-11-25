package pages.TK_A4;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class DataEntryAppeals {

    @FindBy(xpath = "//*[@class=\"popupBody\"]")
    @Getter
    private SelenideElement shouldOpenFormCearchContact;

    @Step("Вводим данные - Фамилия")
    public void ContInSurname(String surname) {
        $("#full_name_advanced").sendKeys(surname);
    }

    public void ContInEmail(String email) {
        $("#email_advanced").sendKeys(email);
    }

    @FindBy(xpath = "//*[@class=\"oddListRowS1\"]//a")
    @Getter
    private SelenideElement shouldHaveSurname;

    @FindBy(xpath = "(//*[@class=\"oddListRowS1\"]//td)[5]")
    @Getter
    private SelenideElement shouldHaveEmail;

    @FindBy(xpath = "(//*[@class=\"panel panel-default\"])[3]")
    @Getter
    private SelenideElement scrollSectionCommunicationMethod;

    @FindBy(xpath = "//*[@value=\"fck\"]")
    @Getter
    private SelenideElement workerFck;

    @FindBy(xpath = "//*[@value=\"invitation\"]")
    @Getter
    private SelenideElement subtypeInvitation;

    @FindBy(xpath = "//*[@value=\"consult_events\"]")
    @Getter
    private SelenideElement topicEvent;

//    @FindBy(xpath = "//*[@value=\"consult_events\"]")
//    @Getter
//    private SelenideElement subsubjectOther;

    public void entryBasicInfo(String descript) {
        $("#tinymce").sendKeys(descript);
    }




}
