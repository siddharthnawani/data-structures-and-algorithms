package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/word-pattern-official/ojquestion#
 * <p>
 * Question
 * 1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
 * 2. You have to find if the words in S2 follow the exact order as characters in S1.
 * <p>
 * Note -> Every string consists of lower-case English letters only.
 * <p>
 * Sample Input
 * abab
 * pep coding pep coding
 * Sample Output
 * true
 ***/
public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        String words[] = str.split(" ");

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(ch) == false) {
                if (used.containsKey(word) == true) {
                    return false;
                }
                map.put(ch, word);
                used.put(word, true);

            } else {
                String mwith = map.get(ch);
                if (word.equals(mwith) == false) {
                    return false;
                }
            }


        }
        return true;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        String words = scn.nextLine();
        System.out.println(wordPattern(pattern, words));
    }
}
