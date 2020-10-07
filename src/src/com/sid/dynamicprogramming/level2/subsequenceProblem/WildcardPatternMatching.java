package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/wildcard-pattern-matching-official/ojquestion#
 * <p>
 * Question
 * 1. You are given two strings S1 and S2. S1 represents a text and S2 represents a wildcard pattern.
 * 2. You have to print 'true' if the wildcard pattern is matched with the given text, otherwise print 'false'.
 * <p>
 * The wildcard pattern can include the characters '?' and '*'
 * '?' - matches any single character
 * '*' - matches any sequence of characters (including the empty sequence)
 * <p>
 * Sample Input
 * baaabab
 * ba*a?
 * Sample Output
 * true
 **/
public class WildcardPatternMatching {
    public static boolean solution(String str, String pattern) {

        /**
         *Rules while fillign the dp aaray
         * pattern on y axis or row and string on x axis or column
         *
         * 3 rules :
         * if pattern char is
         *  char - if str and pattern char is same check diagonal else false
         *  ? - check diagonal since the current char is consumed/matched with ?
         *  * - check just below entry since char can take blank or the previous entry,
         * as * can be true if any of the next row entry after the pos of * is true;
         *  * can either be empty of it could be 1,2,3.. char
         *
         **/
        boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {

                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if (i == dp.length - 1) {
                    dp[i][j] = false;
                } else if (j == dp[0].length - 1) {
                    if (pattern.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }

                } else {
                    if (pattern.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else if (pattern.charAt(i) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        if (pattern.charAt(i) == str.charAt(j)) {
                            dp[i][j] = dp[i + 1][j + 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }

                }


            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }
}
