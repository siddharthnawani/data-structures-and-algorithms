package src.com.sid.misc;

import java.text.DecimalFormat;

/**
 * 1556. Thousand Separator
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 987
 * Output: "987"
 * Example 2:
 * <p>
 * Input: n = 1234
 * Output: "1.234"
 * Example 3:
 * <p>
 * Input: n = 123456789
 * Output: "123.456.789"
 * Example 4:
 * <p>
 * Input: n = 0
 * Output: "0"
 **/
public class ThousandSeparator {
    public String thousandSeparator(int n) {
        String s = "";
        int c = 0;
        while (n >= 0) {
            int r = n % 10;
            s = r + s;
            n = n / 10;
            if (n <= 0)
                return s;
            c++;
            if (c % 3 == 0)
                s = "." + s;
        }

        return s;
    }

    public String thousandSeparatorUsingDecimalFormat(int n) {
        //String s=String.valueOf(n);
        //s=s.reverse();
        DecimalFormat numberFormat = new DecimalFormat("##,###");
        String str = numberFormat.format(n);
        return str.replaceAll(",", ".");

    }

    public static void main(String[] args) {
        int n = 123456789;
        System.out.println(new ThousandSeparator().thousandSeparator(n));
        System.out.println(new ThousandSeparator().thousandSeparatorUsingDecimalFormat(n));
    }
}
