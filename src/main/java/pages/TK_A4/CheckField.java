package pages.TK_A4;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class CheckField {

    //наводимся на вкладку "Все"
    @FindBy(xpath = "//*[@class=\"desktop-toolbar\"]//*[@class=\"topnav all\"]")
    @Getter
    private SelenideElement allTab;

    //проверяем, что выпадающее меню-список отображается
    @FindBy(xpath = "//*[@class=\"topnav all\"]//ul[@class=\"dropdown-menu\"]")
    @Getter
    private SelenideElement allDropdown;

    //Клик на пункт "Администрирование обращений"
    @FindBy(xpath = "(//*[@class=\"topnav all\"]//*[@class=\"dropdown-menu\"]//a)[6]")
    @Getter
    private SelenideElement adminAppeals;

}
