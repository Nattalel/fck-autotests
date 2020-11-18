package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class PhysicalPerson {

    @FindBy(xpath = "//*[@class=\"topnav all\"]//a[@id=\"moduleTab_9_Физические лица\"]")
    @Getter
    private SelenideElement clickPhysPers;

    @FindBy(xpath = "//*[@class=\"dashboard\"]")
    @Getter
    private SelenideElement ShouldNotHomePage;

    @FindBy(xpath = "//*[@class=\"list-view-rounded-corners\"]")
    @Getter
    private SelenideElement ShouldOpenPhysPers;




    @Step("Создание нового физического лица")
    public void createNewPhysicalPerson() {
        // Клик на "Создать физическое лицо"
        $x("//*[@data-action-name=\"Create\"]").click();
        // Проверяем, что открыта форма создания физического лица.
        $x("//*[@class=\"panel-content\"]").should(Condition.appear);
    }

}
