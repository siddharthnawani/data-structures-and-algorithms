package src.com.sid.dynamicprogramming.level2.pathsProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-distinct-subsequences-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string.
 * 2. You have to print the count of distinct and non-empty subsequences of the given string.
 * <p>
 * Note -> String contains only lowercase letters.
 * <p>
 * Sample Input
 * abc
 * Sample Output
 * 7
 **/
public class CountDistinctSubsequences {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = str.length();

        /**
         *The idea is to have a dp where the ith element will represt
         * all the substring ending with the ith element
         * we just need to be cautious for the repeating elements
         * so that we don;t alreay include what they have already created
         * with the previous one.
         *
         * We will keep a track of elements with a hashmap
         **/

        long[] dp = new long[n + 1];
        dp[0] = 1;
        Map<Character, Integer> lastOccr = new HashMap<>();

        for (int i = 1; i < dp.length; i++) {

            char ch = str.charAt(i - 1);
            dp[i] = 2 * dp[i - 1];

            /**
             *In case there is a repetitve character decrease the new dp
             * by the characters the previous element occurence generated wit
             * the character before it
             **/
            if (lastOccr.containsKey(ch)) {
                int prevOccr = lastOccr.get(ch);
                dp[i] = dp[i] - dp[prevOccr - 1];
            }

            lastOccr.put(ch, i);
        }
        // -1 because we are not considering empty strings
        System.out.println(dp[n] - 1);
    }
}
