package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MenuPage {

    @Step("Проверка появления меню")
    public void menuAppearance() {
        //наводимся на вкладку "Все"
        $x("//*[@class=\"desktop-toolbar\"]//*[@class=\"topnav all\"]").hover();

        //проверяем, что выпадающее меню-список отображается
        $x("//*[@class=\"topnav all\"]//ul[@class=\"dropdown-menu\"]").should(Condition.appear);



    }

}
