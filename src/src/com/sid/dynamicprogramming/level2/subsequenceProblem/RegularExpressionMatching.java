package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/regular-expression-matching-official/ojquestion#
 * <p>
 * Question
 * 1. You are given two strings S1 and S2. S1 represents a text and S2 represents a pattern.
 * 2. You have to print 'true' if the pattern is matched with the given text, otherwise print 'false'.
 * <p>
 * The pattern can include the characters '.' and '*'
 * '.' - matches any single character
 * '*' - matches zero or more of the preceding character
 * <p>
 * Sample Input
 * aa
 * a
 * Sample Output
 * false
 **/
public class RegularExpressionMatching {
    public static boolean solution(String s, String p) {

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    char pc = p.charAt(i - 1);
                    if (pc == '*') {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = false;
                    }

                } else {
                    char pc = p.charAt(i - 1);
                    char sc = s.charAt(j - 1);

                    if (pc == '*') {
                        /**
                         * Either the character 2 row above or if the pattern and
                         * string char matches then the previous row; either of these can work
                         **/
                        dp[i][j] = dp[i - 2][j];
                        char pslc = p.charAt(i - 2);
                        if (pslc == '.' || pslc == sc) {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                        }

                    } else if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }


                }


            }
        }

        return dp[p.length()][s.length()];


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }
}
