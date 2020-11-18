package src.com.sid.companyBasedQuestions.amazon.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Window Substring
 * <p>
 * https://leetcode.com/problems/minimum-window-substring/
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 * <p>
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 **/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> dict = new HashMap<>();

        //prepare the pattern map
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int count = dict.getOrDefault(ch, 0);
            dict.put(ch, count + 1);
        }

        int required = dict.size();

        int found = 0, l = 0, r = 0;
        //to store window length, start index and end index
        int[] ans = {-1, 0, 0};

        Map<Character, Integer> windowCounts = new HashMap<>();

        while (r < s.length()) {
            char ch = s.charAt(r);
            int count = windowCounts.getOrDefault(ch, 0);
            windowCounts.put(ch, count + 1);


            if (dict.containsKey(ch) && dict.get(ch).intValue() == windowCounts.get(ch).intValue()) {
                found++;
            }

            //start minimizing the window
            while (l <= r && found == required) {
                ch = s.charAt(l);
                if (ans[0] == -1 || (r - l + 1) < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                //start decreasing the window size
                windowCounts.put(ch, windowCounts.get(ch) - 1);
                if (dict.containsKey(ch) && windowCounts.get(ch).intValue() < dict.get(ch).intValue()) {
                    found--;
                }

                l++;

            }

            r++;


        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);


    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
