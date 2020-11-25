package pages.createTest;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class EnterValues {

    // Проверка категории контакта
    @FindBy(xpath = "//*[@field=\"contact_category\"]")
    @Getter
    private SelenideElement shouldCotegoryCont;

    // Проверка телефона
    @FindBy(xpath = "//*[@class=\"multiphone-detail\"]/td")
    @Getter
    private SelenideElement shouldPhone;

    // Проверка Email
    @FindBy(xpath = "//*[@class=\"email-link\"]")
    @Getter
    private SelenideElement shouldEmail;

}
