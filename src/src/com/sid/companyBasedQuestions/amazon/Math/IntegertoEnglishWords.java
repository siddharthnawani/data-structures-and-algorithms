package src.com.sid.companyBasedQuestions.amazon.Math;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 * <p>
 * Convert a non-negative integer num to its English words representation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: num = 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= num <= 231 - 1
 *
 * Ref : https://leetcode.com/problems/integer-to-english-words/discuss/70625/My-clean-Java-solution-very-easy-to-understand
 **/
public class IntegertoEnglishWords {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {

        if (num == 0) return "Zero";
        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num = num / 1000;
            i++;

        }

        return words.trim();
    }

    private String helper(int num) {

        if (num == 0) return "";
        else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        int num = 1234567891;
        System.out.println(new IntegertoEnglishWords().numberToWords(num));
    }

}
