package src.com.sid.recursionanddynamicprogramming.recursion.recursionwitharraylists;

import java.util.ArrayList;
import java.util.Arrays;

/***
 *
 * Question
 * 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
 * 2. The following list is the key to characters map :
 *     0 -> .;
 *     1 -> abc
 *     2 -> def
 *     3 -> ghi
 *     4 -> jkl
 *     5 -> mno
 *     6 -> pqrs
 *     7 -> tu
 *     8 -> vwx
 *     9 -> yz
 * 3. Complete the body of getKPC function - without changing signature -
 * to get the list of all words that could be produced by the keys in str.
 * Use sample input and output to take idea about output.
 *
 *
 * This is basically cartesian product.
 *
 *
 * Sample Input
 * 78
 * Sample Output
 * [tv, tw, tx, uv, uw, ux]
 *
 * **/
public class GetKeypadCombination {
    private final String[] codes = {
            ".;",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tu",
            "vwx",
            "yz"};

    private ArrayList<String> getKPC(String str) {

        //base case
        if (str.length() == 0)
            return new ArrayList<>(Arrays.asList(""));


        char fch = str.charAt(0);//extract 1st digit
        String ros = str.substring(1); // keep faith for rest

        ArrayList<String> rres = getKPC(ros);
        ArrayList<String> mres = new ArrayList<>();
        /**Meet faith with expectation here
         * */
        String codeforch = codes[fch - '0'];
        for (char ch : codeforch.toCharArray()) {
            for (String rstr : rres) {
                mres.add(ch + rstr);
            }
        }
        return mres;

    }

    public static void main(String[] args) {
        String str = "78";
        System.out.println(new GetKeypadCombination().getKPC(str));
    }
}
