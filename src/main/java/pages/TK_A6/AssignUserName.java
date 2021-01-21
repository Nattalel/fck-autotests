package pages.TK_A6;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class AssignUserName {

    // Клик на кнопку «Назначить ответственного»
    @FindBy(xpath = "//*[@class=\"custom-button-top-nav\"][1]")
    @Getter
    private SelenideElement clickAssignUserName;

}
