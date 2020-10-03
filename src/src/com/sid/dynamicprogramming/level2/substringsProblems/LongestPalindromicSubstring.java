package src.com.sid.dynamicprogramming.level2.substringsProblems;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lpss-official/ojquestion#
 * <p>
 * 1. You are given a string str.
 * 2. You are required to print the length of longest of palindromic substrings in string str.
 * <p>
 * Sample Input
 * abccbc
 * Sample Output
 * 4
 **/
public class LongestPalindromicSubstring {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        boolean[][] dp = new boolean[str.length()][str.length()];
        int len = 0;

        for (int g = 0; g < str.length(); g++) {

            for (int i = 0, j = g; j < str.length(); i++, j++) {
                if (g == 0)
                    dp[i][j] = true;
                else if (g == 1) {
                    if (str.charAt(i) == str.charAt(j))
                        dp[i][j] = true;

                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true)
                        dp[i][j] = true;
                }

                if (dp[i][j])
                    len = g + 1;
            }
        }

        System.out.println(len);
    }
}
