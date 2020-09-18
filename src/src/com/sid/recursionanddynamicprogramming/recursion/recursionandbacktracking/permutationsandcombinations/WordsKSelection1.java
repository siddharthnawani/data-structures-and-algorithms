package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.util.HashSet;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-kselection-1-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a word (may have one character repeat more than once).
 * 2. You are given an integer k.
 * 2. You are required to generate and print all ways you can select k distinct characters out of the
 * word.
 * <p>
 * Sample Input
 * aabbbccdde
 * 3
 * Sample Output
 * abc
 * abd
 * abe
 * acd
 * ace
 * ade
 * bcd
 * bce
 * bde
 * cde
 */
public class WordsKSelection1 {

    private void generateSelection(int i, String ustr, int ssf, int ts, String asf) {

        if (i == ustr.length()) {
            if (ssf == ts)
                System.out.println(asf);
            return;
        }
        //each box has 2 options so here we are generating all 2^n options
        char ch = ustr.charAt(i);
        generateSelection(i + 1, ustr, ssf + 1, ts, asf + ch);
        generateSelection(i + 1, ustr, ssf, ts, asf);
    }

    public static void main(String[] args) throws Exception {

        String str = "aabbbccdde";
        int k = 3;

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        new WordsKSelection1().generateSelection(0, ustr, 0, k, "");
    }
}
