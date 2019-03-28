package com.xml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtil {
    private static final String PHONE_NUMBER_REGULAR_EXPRESSION = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}\\-\\d{2}\\-\\d{2}$";
    private static final String EMAIL_REGULAR_EXPRESSION = "^\\w+[a-zA-Z0-9\\.\\_\\-]*@([a-zA-Z]+\\.)+[a-zA-Z]+$";
    private static final String DATE_REGULAR_EXPRESSION = "^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|2[0-9])([0-9]{2})$";
    private static final String IP_REGULAR_EXPRESSION = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]?|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]?|[0-9])$";

    public static boolean isPhoneNumberValid(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isDateValid(String date){
        Pattern pattern = Pattern.compile(DATE_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            Pattern subString = Pattern.compile("\\.");
            String[] numbers = subString.split(date);
            return isDateCorrect(numbers[0], numbers[1], numbers[2]);
        } else {
            return false;
        }
    }

    public static boolean isIpValid(String ip) {
        Pattern pattern = Pattern.compile(IP_REGULAR_EXPRESSION);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    private static boolean isDateCorrect(String day, String month, String years) {
        int year = Integer.parseInt(years);
        if (day.equals("31") && isMonthCorrect(month)) {
            return false;
        }
        if (day.equals("30") && month.equals("02")) {
            return false;
        }
        if (day.equals("29") && month.equals("02") && !isYearCorrect(year)) {
            return false;
        }
        return true;
    }

    private static boolean isYearCorrect(int year) {
        return (year % 4 == 0 && (year % 100 != 0 | year % 400 == 0));
    }

    private static boolean isMonthCorrect(String month) {
        return (month.equals("02") | month.equals("04")
                | month.equals("06") | month.equals("09")
                | month.equals("11"));
    }
}
