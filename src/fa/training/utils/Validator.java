package fa.training.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String VALID_PHONE_REGEX = "\\d{10}";

    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile(VALID_PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
