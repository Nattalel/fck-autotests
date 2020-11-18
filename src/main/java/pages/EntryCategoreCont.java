package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class EntryCategoreCont {

    @FindBy(xpath = "//*[@name=\"contact_category\"]")
    @Getter
    private SelenideElement clickCategoreCont;

    @FindBy(xpath = "//*[@value=\"employee\"]")
    @Getter
    private SelenideElement clickCompanyEmployee;

    @FindBy(xpath = "//*[@name=\"contact_category\"]")
    @Getter
    private SelenideElement shouldCategoreCont;


}
