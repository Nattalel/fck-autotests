package utils;

import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum ContactInfo {

    TEST_CONTACTINFO("Авто", "Тест", "Тестович", "6321277661");
    private final String surname;
    private final String name;
    private final String middlename;
    private final String inn;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getInn() {
        return inn;
    }

}
