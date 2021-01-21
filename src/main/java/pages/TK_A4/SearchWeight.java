package pages.TK_A4;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class SearchWeight {

    // Наводим на вкладку "Все"
    @FindBy(xpath = "//*[@class=\"desktop-toolbar\"]//*[@class=\"topnav all\"]")
    @Getter
    private SelenideElement allTab;

    // Проверяем, что выпадающее меню-список отображается
    @FindBy(xpath = "//*[@class=\"topnav all\"]//ul[@class=\"dropdown-menu\"]")
    @Getter
    private SelenideElement allDropdown;

    // Клик на пункт "Администрирование обращений"
    @FindBy(xpath = "(//*[@class=\"topnav all\"]//*[@class=\"dropdown-menu\"]//a)[6]")
    @Getter
    private SelenideElement adminAppeals;

    // Клик на пункт "Обращения"
    @FindBy(xpath = "(//*[@class=\"topnav all\"]//*[@class=\"dropdown-menu\"]//a)[22]")
    @Getter
    private SelenideElement clickAppeals;

    // Проверка, что открыт модуль «Обращения» («Cases»).
    @FindBy(xpath = "//*[@class=\"moduleTitle\"]")
    @Getter
    private SelenideElement shouldAppeals;

    // Фильтрация
    @FindBy(xpath = "(//*[@class=\"glyphicon glyphicon-filter parent-dropdown-handler\"])[1]")
    @Getter
    private SelenideElement сlickFilter;


}
