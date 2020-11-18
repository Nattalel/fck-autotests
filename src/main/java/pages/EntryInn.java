package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class EntryInn {

    @Step("Вводим ИНН")
    public void ContInInn(String inn) {
        $("#inn_advanced").sendKeys(inn);
    }

    @FindBy(xpath = "//*[@id=\"search_form_submit\"]")
    @Getter
    private SelenideElement clickSearch;

    @FindBy(xpath = "//*[@class=\"oddListRowS1\"]//a")
    @Getter
    private SelenideElement clickSearchCompany;

    @FindBy(xpath = "//*[@class=\"oddListRowS1\"]//a")
    @Getter
    private SelenideElement getShouldSize;

    @FindBy(xpath = "//*[@class=\"popupBody\"]")
    @Getter
    private SelenideElement shouldFieldCompany;

    @FindBy(xpath = "//*[@class=\"panel-content\"]")
    @Getter
    private SelenideElement shouldCreatePhysPers;

    @FindBy(xpath = "//*[@name=\"account_name\"]")
    @Getter
    private SelenideElement shouldCategoreCont;

//    @FindBy(css = ".list>tbody tr")
//    @Getter
//    private SelenideElement shouldSize;

}
