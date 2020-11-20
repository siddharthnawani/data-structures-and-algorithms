package src.com.sid.String.SlidingWindow;

import java.util.HashSet;

/***
 * https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
 *
 * 1100. Find K-Length Substrings With No Repeated Characters
 * Given a string S, return the number of substrings of length K with no repeated characters.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "havefunonleetcode", K = 5
 * Output: 6
 * Explanation:
 * There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 * Example 2:
 *
 * Input: S = "home", K = 5
 * Output: 0
 * Explanation:
 * Notice K can be larger than the length of S. In this case is not possible to find any substring.
 *
 * **/
public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {

        HashSet<Character> chars = new HashSet<>();
        int j = 0;
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            while (chars.contains(ch)) {
                chars.remove(S.charAt(j));
                j++;
            }
            chars.add(ch);
            int windowSize = i - j + 1;
            if (windowSize == K) {
                res++;
                //slide the window
                chars.remove(S.charAt(j));
                j++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String S = "havefunonleetcode"; int K = 5;
        System.out.println(new FindKLengthSubstringsWithNoRepeatedCharacters().numKLenSubstrNoRepeats(S, K));
    }
}
