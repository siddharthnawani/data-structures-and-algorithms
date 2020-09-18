package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.util.HashSet;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-klength-words-2-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a word (may have one character repeat more than once).
 * 2. You are given an integer k.
 * 3. You are required to generate and print all k length words (of distinct chars) by using chars of the
 * word.
 * <p>
 * Sample Input
 * aabbbccdde
 * 3
 * Sample Output
 * abc
 * abd
 * abe
 * acb
 * ...
 * ...
 */
public class WordsKLengthWords2 {

    private void generateWords(int cs, int ts, String ustr, HashSet<Character> used, String asf) {

        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < ustr.length(); i++) {
            char ch = ustr.charAt(i);
            if (!used.contains(ch)) {
                used.add(ch);
                generateWords(cs + 1, ts, ustr, used, asf + ch);
                used.remove(ch);
            }
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

        new WordsKLengthWords2().generateWords(1, k, ustr, new HashSet<>(), "");
    }
}
