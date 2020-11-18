package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class NewPhysicalPerson {

    @FindBy(xpath = "//*[@data-action-name=\"Create\"]")
    @Getter
    private SelenideElement clickCreatePhysPers;

    @FindBy(xpath = "//*[@class=\"panel-content\"]")
    @Getter
    private SelenideElement shouldCreatePhysPers;

}
