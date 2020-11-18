package utils;

import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum FieldInn {

    TEST_FIELDINN("6321277661");
    private final String inn;
    public String getInn() {
        return inn;
    }
}
