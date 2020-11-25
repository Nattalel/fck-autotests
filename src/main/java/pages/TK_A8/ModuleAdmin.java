package pages.TK_A8;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class ModuleAdmin {
    //Наведение на test_auto
    @FindBy(xpath = "//*[@title=\"test_auto\"]")
    @Getter
    private SelenideElement testAuto;

    //Выбор модуля Администрирование
    @FindBy(xpath = "//*[@class=\"desktop-bar\"]//*[@id=\"admin_link\"]")
    @Getter
    private SelenideElement fieldAdmin;
}
