package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-of-distinct-palindromic-subsequences-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string.
 * 2. You have to print the count of distinct and non-empty palindromic subsequences in the given string.
 * 3. Two sequences s1 and s2 are distinct if here is some i, for which ith character in s1 and s2 are different.
 * <p>
 * Note -> String contains only lowercase letters.
 * -> The answer will be in the integer range only.
 * <p>
 * Sample Input
 * bccb
 * Sample Output
 * 6
 **/
public class CountOfDistinctPalindromicSubsequences {

    public static int solution(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int[] prev = new int[n];
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (!hm.containsKey(ch)) {
                prev[i] = -1;
            } else {
                prev[i] = hm.get(ch);
            }
            hm.put(ch, i);
        }

        int[] next = new int[n];
        hm.clear();

        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (!hm.containsKey(ch)) {
                next[i] = -1;
            } else {
                next[i] = hm.get(ch);
            }
            hm.put(ch, i);
        }

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {

                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = 2;
                } else {
                    char sc = str.charAt(i);
                    char ec = str.charAt(j);

                    if (sc != ec) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    } else {
                        int ni = next[i];
                        int p = prev[j];

                        if (ni > p) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if (ni == p) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[ni + 1][p - 1];
                        }

                    }


                }


            }
        }

        return dp[0][n - 1];

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
