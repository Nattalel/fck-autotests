package utils;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum ContactData {

    TEST_CONTACTDATA("1111111111", "test@mail.ru");
    private final String phone;
    private final String email;

    @Step("Получение Телефона")
    public String getPhone() {
        return phone;
    }
    @Step("Получение Email")
    public String getEmail() { return email; }


}
