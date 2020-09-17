package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.util.HashMap;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-words-1-official/ojquestion#
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
 *
 * ---------
 * Approach :
 *
 * Here boxes are at level and items/words are at options
 *
 *
 * B1  -> X _ _  It has 3 options blank, A , B
 * B1_ -> _ _ _  It has 3 options blank, A , B
 * B1A -> A _ _ It has 2  options blank , B
 * B1B -> B _ _ It has 2  options blank , A
 *
 * and so on..
 */
public class PermutationsWords1 {

    private void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {

        if (cs > ts) {
            System.out.println(asf);
            return;
        }

        for (char ch : fmap.keySet()) {

            if (fmap.get(ch) > 0) {

                fmap.put(ch, fmap.get(ch) - 1);
                generateWords(cs + 1, ts, fmap, asf + ch);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String str = "aabb";

        HashMap<Character, Integer> fmap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }
        new PermutationsWords1().generateWords(1, str.length(), fmap, "");
    }
}
