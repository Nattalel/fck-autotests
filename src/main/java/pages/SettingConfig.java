package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class SettingConfig {

    //Клик на настройки конфигурации
    @FindBy(xpath = "//*[@id=\"configphp_settings\"]")
    @Getter
    private SelenideElement сlickSettingConfig;

    //Проверка, что открыты настройки конфигурации
    @FindBy(xpath = "//*[@class=\"module-title-text\"]")
    @Getter
    private SelenideElement shouldOpenPhysPers;

    // Проверка,что модуль "Администрирование" открыт
    @FindBy(xpath = "//*[@id=\"pagecontent\"]//h2")
    @Getter
    private SelenideElement shouldfieldAdmin;

}
