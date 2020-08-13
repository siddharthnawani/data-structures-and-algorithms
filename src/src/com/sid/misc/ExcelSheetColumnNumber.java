package src.com.sid.misc;

/**
 * 171. Excel Sheet Column Number
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 **/
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int ans = 0, p = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = c - 'A' + 1;
            ans += Math.pow(26, p) * val;
            p++;
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "ZY";
        System.out.println(new ExcelSheetColumnNumber().titleToNumber(s));
    }
}
