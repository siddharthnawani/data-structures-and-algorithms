package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.util.HashSet;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/words-klength-words-1-official/ojquestion#
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
 * adb
 * aeb
 * ...
 * ...
 */
public class WordsKLengthWords1 {

    private void generateWords(int cc, String ustr, int ssf, int ts, Character[] spots) {

        if (cc == ustr.length()) {
            if (ssf == ts) {
                for (char ch : spots)
                    System.out.print(ch);
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(cc);
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                generateWords(cc + 1, ustr, ssf + 1, ts, spots);
                spots[i] = null;
            }
        }

        generateWords(cc + 1, ustr, ssf, ts, spots);
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

        Character[] spots = new Character[k];
        new WordsKLengthWords1().generateWords(0, ustr, 0, k, spots);
    }
}
