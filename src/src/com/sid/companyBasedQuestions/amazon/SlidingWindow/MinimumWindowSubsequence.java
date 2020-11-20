package src.com.sid.companyBasedQuestions.amazon.SlidingWindow;

/**
 * https://github.com/shehabic/java-algorithms/blob/master/src/solutions/MinWindowSubSequence.java
 * <p>
 * https://www.youtube.com/watch?v=W2DvQcDPD9A
 * <p>
 * 727. Minimum Window Subsequence
 * https://leetcode.com/problems/minimum-window-subsequence/
 * <p>
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 **/
public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        String minWindow = "";

        int j = 0;//for matching characters in T
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++; //increment j to next char
                if (j == T.length()) // time to capture the current length
                {
                    //start looking for any short answers from right this time
                    //start decreasing j and go towards the start of j
                    int end = i + 1; //for current window
                    j--;//put j back to last match character
                    while (j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) {
                            j--;
                        }
                        i--;
                    }
                    j++;//j would be -1 , so put it back to 0
                    i++; // now i is pointing to the first character of T in S


                    int currLen = end - i;
                    if (currLen < minLen) {
                        minLen = currLen;
                        minWindow = S.substring(i, end);
                    }

                }
            }//i will be incremented by the for loop automatically
        }


        return minWindow;
    }

    public static void main(String[] args) {
        String S = "abcdebdde";
        String T = "bde";
        System.out.println(new MinimumWindowSubsequence().minWindow(S, T));
    }
}
