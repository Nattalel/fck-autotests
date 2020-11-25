package utils;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum ContactInfoAppeals {

    TEST_CONTACTINFOAPPEALS("Ласточкин", "testlkvp@mail.ru");

    private final String surname;
    private final String email;

    public String getSurname() {
        return surname;
    }
    public String getEmail() { return email; }

}
