package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class PhysicalPerson {

    @Step("Создание физического лица")
    public void createPhysicalPerson() {

        // Клик на пункт «Физические лица»
        $x("//*[@class=\"topnav all\"]//a[@id=\"moduleTab_9_Физические лица\"]").click();

        // Проверяем, что домашняя страница закрыта
        $x("//*[@class=\"dashboard\"]").shouldNot(Condition.appear);
        // Проверяем, что открыта форма просмотра модуля «Физические лица»
        $x("//*[@class=\"list-view-rounded-corners\"]").should(Condition.appear);
    }

    @Step("Создание нового физического лица")
    public void createNewPhysicalPerson() {
        // Клик на "Создать физическое лицо"
        $x("//*[@data-action-name=\"Create\"]").click();
        // Проверяем, что открыта форма создания физического лица.
        $x("//*[@class=\"panel-content\"]").should(Condition.appear);
    }

}
