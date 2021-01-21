package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class LogViewport {

    //Клик на просмотр журнала
    @FindBy(xpath = "(//*[@target=\"_blank\"])[1]")
    @Getter
    private SelenideElement clickViewLog;

    //Форма просмотра логов
    @FindBy(xpath = "")
    @Getter
    private SelenideElement formViewLog;

}
