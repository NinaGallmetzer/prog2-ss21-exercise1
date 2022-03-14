package exercise01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

    public boolean checkPassword(String pwToCheck) {
        return checkNotEmpty(pwToCheck) && checkLength(pwToCheck) &&
                checkUpperCase(pwToCheck) && checkLowerCase(pwToCheck) &&
                checkDigit(pwToCheck) && checkSpecialCharacters(pwToCheck) &&
                checkConsecutiveDigits(pwToCheck) && checkDigitQuartett(pwToCheck);
    }

    public static boolean checkNotEmpty(String pwToCheck) {
        return !pwToCheck.isEmpty();
    }

    public static boolean checkLength(String pwToCheck) {
        return pwToCheck.length() >= 8 && pwToCheck.length() <= 25;
    }

    public static boolean checkLowerCase(String pwToCheck) {
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(pwToCheck);
        return m.find();
    }

    public static boolean checkUpperCase(String pwToCheck) {
        Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(pwToCheck);
        return m.find();
    }

    public static boolean checkDigit(String pwToCheck) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(pwToCheck);
        return m.find();
    }

    public static boolean checkSpecialCharacters(String pwToCheck) {
        Pattern p = Pattern.compile("[^\\w[^()#$?!%/@]]");
        Matcher m = p.matcher(pwToCheck);
        return m.find();
    }

    public static boolean checkConsecutiveDigits(String pwToCheck) {
        for (int i = 0; i < pwToCheck.length()-2; i++) {
            if (Character.isDigit(pwToCheck.charAt(i)) && Character.isDigit(pwToCheck.charAt(i+1)) && Character.isDigit(pwToCheck.charAt(i+2))) {
                int d1 = pwToCheck.charAt(i);
                int d2 = pwToCheck.charAt(i+1);
                int d3 = pwToCheck.charAt(i+2);
                if ((d1 == d2-1) && (d2 == d3-1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkDigitQuartett(String pwToCheck) {
        for (int i = 0; i < pwToCheck.length()-3; i++) {
            if (Character.isDigit(pwToCheck.charAt(i)) && Character.isDigit(pwToCheck.charAt(i+1)) && Character.isDigit(pwToCheck.charAt(i+2)) && Character.isDigit(pwToCheck.charAt(i+3))) {
                int d1 = pwToCheck.charAt(i);
                int d2 = pwToCheck.charAt(i+1);
                int d3 = pwToCheck.charAt(i+2);
                int d4 = pwToCheck.charAt(i+3);
                if ((d1 == d2) && (d1 == d3) && (d1 == d4)) {
                    return false;
                }
            }
        }
        return true;
    }

}
