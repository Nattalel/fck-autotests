package pages.TK_A4;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class Appeals {

    @FindBy(xpath = "(//*[@class=\"topnav all\"]//*[@class=\"dropdown-menu\"]//a)[22]")
    @Getter
    private SelenideElement clickAppeals;

    @FindBy(xpath = "//*[@class=\"moduleTitle\"]")
    @Getter
    private SelenideElement shouldAppeals;

}
