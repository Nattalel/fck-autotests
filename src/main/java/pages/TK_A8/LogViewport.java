package pages.TK_A8;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class LogViewport {

    //Клик на настройки конфигурации
    @FindBy(xpath = "")
    @Getter
    private SelenideElement clickViewLog;

    //Форма просмотра логов
    @FindBy(xpath = "")
    @Getter
    private SelenideElement formViewLog;

}
