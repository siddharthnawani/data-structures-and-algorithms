package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-encodings-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string str of digits. (will never start with a 0)
 * 2. You are required to encode the str as per following rules
 * 1 -> a
 * 2 -> b
 * 3 -> c
 * ..
 * 25 -> y
 * 26 -> z
 * 3. You are required to calculate and print the count of encodings for the string str.
 * <p>
 * For 123 -> there are 3 encodings. abc, aw, lc
 * For 993 -> there is 1 encoding. iic
 * For 013 -> This is an invalid input. A string starting with 0 will not be passed.
 * For 103 -> there is 1 encoding. jc
 * For 303 -> there are 0 encodings. But such a string maybe passed. In this case
 * print 0.
 * <p>
 * <p>
 * Sample Input
 * 123
 * Sample Output
 * 3
 **/
public class CountEncodings {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        int[] dp = new int[str.length()];

        /**
         *Since it is mentioned in the question that string will never
         * start from 0 we can directly take dp[0]=1 as well;
         *
         **/
        if (str.charAt(0) != '0')
            dp[0] = 1;
        else {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < dp.length; i++) {

            /**
             * Like ...00
             * */
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;

            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {

                    /**
                     * For Ex: 210
                     * Here we can split it into 2-10 only hence dp[i-2];
                     * as 21-0 makes no sense
                     *
                     **/

                    //We dont run into ArrayIndexOutOfBoundException
                    if (i >= 2) {
                        dp[i] = dp[i - 2];
                    }
                    /**
                     *Number is less than 26 but the array length or
                     * the current iteration is at array index 1
                     * for ex :
                     * 20
                     * so here we will consider the whole number as
                     * a decoding.
                     **/
                    else {
                        dp[1] = 1;
                    }

                } else {
                    /**
                     *if we have a string which is ending with 0 and
                     * number inlcung second last character is greater
                     * than 26 we cannot make any decodings with it
                     *
                     **/
                    dp[i] = 0;
                }

            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                /**
                 * Like ...05
                 * */
                dp[i] = dp[i - 1];
            } else {

                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    if (i >= 2) {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    } else
                        dp[i] = dp[i - 1] + 1;

                } else
                    dp[i] = dp[i - 1];
            }

        }

        System.out.println(dp[str.length() - 1]);

    }
}
