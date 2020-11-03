package src.com.sid.companyBasedQuestions.amazon.ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringUsingO2n(String s) {

        int res = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        //sliding window
        while (i < s.length() && j < s.length()) {
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                int len = j - i + 1;
                j++;
                if (len > res) {
                    res = len;
                }
                set.add(ch);
            } else {
                char ith = s.charAt(i);
                set.remove(ith);
                i++;
            }
        }
        return res;

    }

    public int lengthOfLongestSubstring(String s) {

        int res = 0;
        //for Storing next to latest index of charater
        HashMap<Character, Integer> map = new HashMap<>();


        for (int i = 0, j = 0; j < s.length(); j++) {

            //if you encounter an alredy seen character just update i to skip the last occurence of it.
            char jth = s.charAt(j);
            if (map.containsKey(jth)) {
                i = Math.max(i, map.get(jth));
            }
            int len = j - i + 1;
            res = Math.max(res, len);
            map.put(jth, j + 1);


        }


        return res;

    }

    public static void main(String[] args) {
        String ip="abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(ip));
    }
}
