package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class FieldCompany {

    @FindBy(xpath = "//*[@name=\"btn_account_name\"]")
    @Getter
    private SelenideElement clickFieldCompany;

    @FindBy(xpath = "//*[@class=\"popupBody\"]")
    @Getter
    private SelenideElement shouldFieldCompany;




}
