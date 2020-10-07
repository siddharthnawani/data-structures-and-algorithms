package src.com.sid.dynamicprogramming.level2.subsequenceProblem;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lcs-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string str1.
 * 2. You are given another string str2.
 * 3. You are required to print the length of longest common subsequence of two strings.
 * <p>
 * Sample Input
 * abcd
 * aebd
 * Sample Output
 * 3
 **/
public class LongestCommonSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        /**
         *Here we ware storiing the blank in the last place also
         * formula is :
         *
         * LCS(c1r1 , c2r2)
         *
         * if c1==c2
         * LCS(r1,r2) +1
         *
         *
         * if c1!=c2
         * Max(LCS(s1,r2),LCS(r1,s2))
         **/
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }

            }
        }

        System.out.println(dp[0][0]);


    }
}
