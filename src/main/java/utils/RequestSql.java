package utils;

import lombok.AllArgsConstructor;

//аннотация для генерации конструктора со всеми параметрами
@AllArgsConstructor
public enum RequestSql {

//    TEST_REQUESTSQL("SELECT securitygroup_id " +
//            "FROM `securitygroups_users` " +
//            "WHERE `user_id` LIKE '67d2a2e2-5f6e-423c-6894-5f74970445f3' AND for_filter='1'");

    TEST_REQUESTSQL("/");

    private final String sql;

    public String getSql() {
        return sql;
    }



}
