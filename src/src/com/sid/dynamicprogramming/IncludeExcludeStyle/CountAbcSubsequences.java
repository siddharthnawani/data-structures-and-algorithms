package src.com.sid.dynamicprogramming.IncludeExcludeStyle;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-a+b+c+subsequences-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string str.
 * 2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
 * For abbc -> there are 3 subsequences. abc, abc, abbc
 * For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
 * <p>
 * Sample Input
 * abcabc
 * Sample Output
 * 7
 **/
public class CountAbcSubsequences {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        /**
         *Here the idea is to have 3 subsequence of form
         *
         * a ; ab ; abc
         *
         * when we encounter a the subsequence of form a will be impacted
         *
         * when we encounter b the subsequence of form ab will be impacted
         * plus all the sub seq of a will be added as well
         *
         *  when we encounter c the subsequence of form abc will be impacted
         *  plus all the sub seq of ab will be added as well
         **/
        int aSubseq = 0;
        int abSubseq = 0;
        int abcSubseq = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'a') {
                aSubseq = 2 * aSubseq + 1;

            } else if (str.charAt(i) == 'b') {
                abSubseq = 2 * abSubseq + aSubseq;
            } else if (str.charAt(i) == 'c') {
                abcSubseq = 2 * abcSubseq + abSubseq;
            }
        }

        System.out.println(abcSubseq);

    }
}
