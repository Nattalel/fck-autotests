package pages.createTest;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class PhysicalPerson {

    @FindBy(xpath = "(//*[@class=\"topnav all\"]//*[@class=\"dropdown-menu\"]//a)[4]")
    @Getter
    private SelenideElement clickPhysPers;

    @FindBy(xpath = "//*[@class=\"dashboard\"]")
    @Getter
    private SelenideElement ShouldNotHomePage;

    @FindBy(xpath = "//*[@class=\"list-view-rounded-corners\"]")
    @Getter
    private SelenideElement ShouldOpenPhysPers;

}
