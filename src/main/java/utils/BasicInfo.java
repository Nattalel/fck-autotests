package utils;

import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum BasicInfo {

    TEST_DESCRIPTION("Текст описания");
    private final String descript;

    public String getDescript() { return descript; }

}
