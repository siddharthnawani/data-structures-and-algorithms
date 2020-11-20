package src.com.sid.companyBasedQuestions.amazon.SlidingWindow;

/**
 * 567. Permutation in String
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 **/
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() == 0 || s2.length() == 0 || s2.length() < s1.length())
            return false;

        //maintain 1 array map of 26 characters
        //in a rolling window manner check if theere is any window in s2 which match with s1
        int[] char_ary = new int[26];
        int m = s1.length();
        int n = s2.length();

        for (int i = 0; i < m; i++) {
            char_ary[s1.charAt(i) - 'a']--;
            char_ary[s2.charAt(i) - 'a']++;
        }

        //here we strat comparing the rolling windows
        for (int i = m; i < n; i++) {
            //check the previous window first
            if (areAllZeros(char_ary))
                return true;

            //now slide the window
            //remove first charater
            char_ary[s2.charAt(i - m) - 'a']--;
            //add the current character
            char_ary[s2.charAt(i) - 'a']++;
        }

        //check last character wndow also
        if (areAllZeros(char_ary))
            return true;

        return false;

    }

    boolean areAllZeros(int[] char_ary) {
        for (int i = 0; i < 26; i++) {
            if (char_ary[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(new PermutationinString().checkInclusion(s1, s2));
    }

}
