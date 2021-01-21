package utils;

import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum  SiteDb {

    TEST_SITEDB("user_auto", "crmbdpasswauto");

    private final String input_username;
    private final String input_password;

    public String getUsernameInput() {
        return input_username;
    }

    public String getPasswordInput() {
        return input_password;
    }

}
