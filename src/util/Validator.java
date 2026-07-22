package util;

public class Validator {

    public static boolean isValidMobile(String mobile) {
        return mobile.matches("^(\\+91|91|0)?[6-9]\\d{9}$");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidPan(String pan) {
        return pan.matches("^[A-Z]{3}[ABCFGHLJPT][A-Z]\\d{4}[A-Z]$");
    }

    public static boolean isValidIFSC(String ifsc) {
        return ifsc.matches("^[A-Z]{4}0[A-Z0-9]{6}$");
    }

    public static boolean isValidAmount(String amount) {
        return amount.matches("^[1-9]\\d*$");
    }
}
