package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.util.HashSet;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/word-kselection-2-official/ojquestion#
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
public class WordsKSelection2 {
    private void generateSelection(String ustr, int cs, int ts, int lc, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        //Options : boxes ; Levels : Selected items
        for (int i = lc + 1; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            generateSelection(ustr, cs + 1, ts, i, asf + ch);
        }
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

        new WordsKSelection2().generateSelection(ustr, 1, k, -1, "");
    }
}
