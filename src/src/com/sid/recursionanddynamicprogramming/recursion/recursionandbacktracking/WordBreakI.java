package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/wordbreak1official/ojquestion#
 * <p>
 * Question
 * 1. You are given n space separated strings, which represents a dictionary of words.
 * 2. You are given another string which represents a sentence.
 * 3. You have to print all possible sentences from the string, such that words of the sentence are
 * present in dictionary.
 * <p>
 * Sample Input
 * 11
 * i like pep coding pepper eating mango man go in pepcoding
 * ilikepeppereatingmangoinpepcoding
 * <p>
 * Sample Output
 * <p>
 * i like pepper eating man go in pep coding
 * i like pepper eating man go in pepcoding
 * i like pepper eating mango in pep coding
 * i like pepper eating mango in pepcoding
 */
public class WordBreakI {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dict.add(scn.next());
        }
        String sentence = scn.next();
        new WordBreakI().wordBreak(sentence, "", dict);
    }

    private void wordBreak(String str, String ans, HashSet<String> dict) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dict.contains(left)) {
                String right = str.substring(i + 1);
                wordBreak(right, ans + left + " ", dict);
            }
        }

    }
}
