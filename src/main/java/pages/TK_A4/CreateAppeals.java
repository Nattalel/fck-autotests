package pages.TK_A4;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class CreateAppeals {

    @FindBy(xpath = "(//*[@class=\"actionmenulink\"])[1]")
    @Getter
    private SelenideElement clickCreateAppeals;

    @FindBy(xpath = "//*[@class=\"moduleTitle\"]")
    @Getter
    private SelenideElement shouldCreateAppeals;

}
