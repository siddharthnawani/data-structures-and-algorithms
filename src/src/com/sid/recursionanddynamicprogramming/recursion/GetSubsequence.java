package src.com.sid.recursionanddynamicprogramming.recursion;

import java.util.ArrayList;

/***
 * For String of length n
 *
 * 2^n Subsequence like : "", a,b,c,ab,ac,bc,abc
 *
 * [n(n+1)] / 2 : substring like : a,ab,abc,bc,c
 *
 *
 * ***/

/***
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-subsequence-official/ojquestion
 * Question
 * 1. You are given a string str.
 * 2. Complete the body of getSS function - without changing signature -
 * to calculate all subsequences of str.
 * Use sample input and output to take idea about subsequences.
 *
 *Sample Input
 * abc
 * Sample Output
 * [, c, b, bc, a, ac, ab, abc]
 *
 * **/
public class GetSubsequence {
    public static void main(String[] args) throws Exception {
        String s = "abc";
        System.out.println(new GetSubsequence().gss(s));
    }

    public ArrayList<String> gss(String str) {

        //base case
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);//retrieve the first element
        ArrayList<String> rres = gss(str.substring(1));
        ArrayList<String> mres = new ArrayList<>();
        for (String s : rres) {
            mres.add("" + s);
            mres.add(ch + s);
        }
        return mres;

    }
}
