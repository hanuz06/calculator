import java.util.regex.*;

public class RomanNumbers {
    public static boolean isValid(String romanNumber) {
        String pattern = "[m|d|c|l|x|v|i]*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(romanNumber);
        return m.matches();
    }

    // Returns decimal value of a
    // given romal numeral
    public static int romanToDecimal(String r) {
        switch (r) {
            case "i":
                return 1;
            case "ii":
                return 2;
            case "iii":
                return 3;
            case "iv":
                return 4;
            case "v":
                return 5;
            case "vi":
                return 6;
            case "vii":
                return 7;
            case "viii":
                return 8;
            case "ix":
                return 9;
            case "x":
                return 10;
            default:
                return -1;
        }
    }

    // Returns roman numeral of given decimal value
    public static String decimalToRoman(int num) {
        String res = "";
        if (num < 0) {
            res += '-';
        }
        num = Math.abs(num);        
        while (num >= 100) {
            res += "c";
            num -= 100;
        }
        while (num >= 90) {
            res += "xc";
            num -= 90;
        }
        while (num >= 50) {
            res += "l";
            num -= 50;
        }
        while (num >= 40) {
            res += "xl";
            num -= 40;
        }
        while (num >= 10) {
            res += "x";
            num -= 10;
        }
        while (num >= 9) {
            res += "ix";
            num -= 9;
        }
        while (num >= 5) {
            res += "v";
            num -= 5;
        }
        while (num >= 4) {
            res += "iv";
            num -= 4;
        }
        while (num >= 1) {
            res += "i";
            num -= 1;
        }
        return res.toUpperCase();
    }
}