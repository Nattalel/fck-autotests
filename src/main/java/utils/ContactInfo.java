package utils;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum ContactInfo {

    TEST_CONTACTINFO("Авто1", "Тест", "Тестович", "6321277661", "Менеджер");
    private final String surname;
    private final String name;
    private final String middlename;
    private final String inn;
    private final String position;

    @Step("Получение Фамилии")
    public String getSurname() {
        return surname;
    }
    @Step("Получение Имени")
    public String getName() {
        return name;
    }
    @Step("Получение Отчества")
    public String getMiddlename() {
        return middlename;
    }
    @Step("Получение Инн")
    public String getInn() {
        return inn;
    }
    @Step("Получение Должности")
    public String getPosition() {
        return position;
    }

}
