package autotests.myTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.DataEntry;
import pages.LoginPage;
import pages.MenuPage;
import pages.PhysicalPerson;
import utils.ContactInfo;
import utils.User;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;



public class CreateIndividual {

    @Test(description = "Тест создание физического лица")
    @Description("Проверка появления меню")
    public void createPersonTest() {
        // открытие приложения
        open("http://fckproject.itfbgroup.ru/fcktest_001/");

        //авторизация
        LoginPage loginPage = page(LoginPage.class);
        loginPage.logIn(User.TEST_USER.getUsername(), User.TEST_USER.getPassword());

        // 1. Выбрать закладку модулей «Все»
        MenuPage menuPage = page(MenuPage.class);
        menuPage.menuAppearance();

        // 2. В выпадающем списке выбрать пункт «Физические лица»
        PhysicalPerson physicalPerson = page(PhysicalPerson.class);
        physicalPerson.createPhysicalPerson();

        // 3. В меню модуля выбрать пункт «Создать новое физическое лицо».
        physicalPerson.createNewPhysicalPerson();

        // 4-6. Заполнение полей Имя, Фамилия, Отчество
        DataEntry dataEntry = page(DataEntry.class);
        dataEntry.ContIn(ContactInfo.TEST_CONTACTINFO.getSurname(),
                ContactInfo.TEST_CONTACTINFO.getName(),
                        ContactInfo.TEST_CONTACTINFO.getMiddlename());

        // 7. Заполнение поля «Категория контакта»
        dataEntry.categotyCont();

        // 8. Заполнение поля  «Предприятие»
        dataEntry.company();

        //9. Заполняем ИНН
        //dataEntry.ContInInn(ContactInfo.TEST_CONTACTINFO.getInn());

        //10. Нажимаем на кнопку «Найти».
        //dataEntry.search();


    }



    }


