package com.example.fm6app.service.utils;

public class StringUtil {
    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static String addConstraint(String beanAbrev, String atributeName, String operator, Object value) {
        boolean condition = value != null;
        if(value == null){
            return "";
        }
        if (value != null && value.getClass().getSimpleName().equals("String")) {
            condition = condition && !value.equals("");
        }
        if (condition && operator.equals("LIKE")) {
            return " AND " + beanAbrev + "." + atributeName + " " + operator + " '%" + value + "%'";
        } else if (condition) {
            return " AND " + beanAbrev + "." + atributeName + " " + operator + " '" + value + "'";
        }
        return "";
    }
}
