package src.com.sid.dynamicprogramming.level2.substringsProblems;

import java.util.Scanner;

/**
 * Question
 * 1. You are given a string str.
 * 2. You are required to print the count of palindromic substrings in string str.
 * <p>
 * Sample Input
 * abccbc
 * Sample Output
 * 9
 **/
public class CountPalindromicSubstrings {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        /**
         * The idea is to have a 2D dp matrix where row would denote the starting point
         * and column will denote the ending point of substrings.
         *
         * row length and column length == length of string
         *
         * Traverse diagonally in the boolean matrix , actually each
         * i,j entry will represent the substring of the original string
         *
         * the lower half of the diagonal need not to be vistes as those
         * are not applicable to our symbolic meaning of i and j..
         *
         * so start traversing diagonaaly and for each string checck if
         * it a palindrome or not, a palindrome is something whose edges are
         * same and the internal area is palindrome in itself, which we can find
         * from the matriz itself.
         *
         **/
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;

        //traverse diagonally
        for (int g = 0; g < s.length(); g++) {

            //since each diagonal start from 0 row and gth column
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                //this is the first diagonal, it will be true since 1 character is plaindrome in itself
                if (g == 0) {
                    dp[i][j] = true;

                }
                //2nd diagonal, check for the peripherals
                else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                //for the remainder of diagonals
                else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;

                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    count++;
                }
            }


        }

        System.out.println(count);
    }
}
