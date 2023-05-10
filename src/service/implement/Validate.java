package service.implement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String USERNAME = "^[_a-z0-9]{6,16}$";
private static final String PASSWORD = "^((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})$";
private static final String EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
private static final String PHONE_NUMBER = "^0([5-9]{1})[0-9]{8}$";
    public Validate() {
    }

    public boolean validateUsername(String regex) {
        Pattern pattern = Pattern.compile(USERNAME);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePassword(String regex) {
        Pattern pattern = Pattern.compile(PASSWORD);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
