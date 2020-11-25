package pages.TK_A8;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class SettingConfig {

    //Клик на настройки конфигурации
    @FindBy(xpath = "//*[@id=\"configphp_settings\"]")
    @Getter
    private SelenideElement сlickSettingConfig;

}
