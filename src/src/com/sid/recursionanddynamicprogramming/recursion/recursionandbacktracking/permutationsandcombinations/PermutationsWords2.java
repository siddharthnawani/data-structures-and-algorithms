package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.util.HashMap;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-words-2-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a word (may have one character repeat more than once).
 * 2. You are required to generate and print all arrangements of these characters.
 * <p>
 * Sample Input
 * aabb
 * Sample Output
 * aabb
 * abab
 * abba
 * baab
 * baba
 * bbaa
 * -----
 * Approach
 * <p>
 * Here Items/words are at level and boxes are at options level
 */
public class PermutationsWords2 {

    private void generateWords(int cc, String str, Character[] spots,
                               HashMap<Character, Integer> lastOccurence) {

        if (cc == str.length()) {
            for (char ch : spots)
                System.out.print(ch);
            System.out.println();
            return;
        }

        char ch = str.charAt(cc);
        int lo = lastOccurence.get(ch);

        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                lastOccurence.put(ch, i);
                spots[i] = ch;
                generateWords(cc + 1, str, spots, lastOccurence);
                lastOccurence.put(ch, lo);
                spots[i] = null;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        String str = "aabb";

        Character[] spots = new Character[str.length()];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (char ch : str.toCharArray()) {
            lastOccurence.put(ch, -1);
        }

        new PermutationsWords2().generateWords(0, str, spots, lastOccurence);
    }
}
