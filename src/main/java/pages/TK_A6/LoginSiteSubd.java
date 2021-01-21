package pages.TK_A6;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginSiteSubd {

    @Step("Логинимся на сайте СУБД")
    public void logInSite(String input_username, String input_password) {
        $("#input_username").sendKeys(input_username);
        $("#input_password").sendKeys(input_password);
    }

}
