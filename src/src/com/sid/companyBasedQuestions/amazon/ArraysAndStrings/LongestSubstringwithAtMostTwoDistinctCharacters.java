package src.com.sid.companyBasedQuestions.amazon.ArraysAndStrings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * <p>
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 **/
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int res = 0;

        if (s.length() < 3) {
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, h = 0;

        while (h < s.length()) {
            char jth = s.charAt(h);
            map.put(jth, h);
            h++;
            if (map.size() > 2) {
                //remove left most value from map
                //int left_idx=Collections.min(map.values());
                int left_idx = s.length();
                for (int i : map.values()) {
                    left_idx = Math.min(left_idx, i);
                }
                char left = s.charAt(left_idx);
                map.remove(left);
                l = left_idx + 1;
            }

            int len = h - l;
            res = Math.max(len, res);

        }

        return res;

    }

    public static void main(String[] args) {
        String ip = "eceba";
        System.out.println(new LongestSubstringwithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct(ip));
    }
}
