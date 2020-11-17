package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DataEntry {

    @Step("Вводим данные - Фамилия, Имя, Отчество")
    public void ContIn(String surname, String name, String middlename) {
        $("#last_name").sendKeys(surname);
        $("#first_name").sendKeys(name);
        $("#second_name").sendKeys(middlename);
    }

    @Step("Ввод в поле Категория контакта")
    public void categotyCont() {
        // Кликаем на выпадающий список в разделе "Категория контакта"
        $x("//*[@name=\"contact_category\"]").click();
        // Выбираем "Сотрудник предприятия"
        $x("//*[@value=\"employee\"]").click();

        //проверяем, что выпадающее меню-список отображается
        //$x("//*[@class=\"topnav all\"]//ul[@class=\"dropdown-menu\"]").should(Condition.appear);
    }

    @Step("Ввод в поле Предприятие")
    public void company() {
        // Кликаем на стрелочку
        $x("//*[@name=\"btn_account_name\"]").click();
        //Проверяем, что форма поиска предприятия.
        //$x("//*[@class=\"popupBody\"]").should(Condition.appear);

    }


    @Step("Заполняем инн")
    public void ContInInn(String inn) {
        $("#inn_advanced").sendKeys(inn);
    }


    @Step("Ввод в поле Предприятие")
    public void search() {
        // Нажимаем кнопку "Найти"
        $x("//*[@id=\"search_form_submit\"]").click();

    }



}
