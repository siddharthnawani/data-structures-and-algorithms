package src.com.sid.companyBasedQuestions.microsoft.String;

/***
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * 214. Shortest Palindrome
 *
 * Given a string s, you can convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: "dcbabcd"
 *
 * **/
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String sdash = s + "#" + new StringBuilder(s).reverse().toString();
        int lenOfPalindrome = getLPS(sdash);

        return new StringBuilder(s.substring(lenOfPalindrome)).reverse().toString() + s;
    }

    private int getLPS(String s) {

        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[s.length() - 1];

    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(new ShortestPalindrome().shortestPalindrome(s));
    }
}
