package src.com.sid.companyBasedQuestions.amazon.ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 **/
public class MostCommonWord {
    public String mostCommonWord_approach_1(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet<>();
        for (String word : banned)
            bannedWords.add(word);

        String ans = "";
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char currChar = chars[i];

            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (i != chars.length - 1)
                    continue;
            }

            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }

                }
                wordBuffer = new StringBuilder();

            }
        }


        return ans;

    }

    private class Trie {
        Trie[] next = new Trie[26];
        int count;
        boolean isBanned;
    }

    public String mostCommonWord_UsingTrie(String paragraph, String[] banned) {
        //build a trie with banned words
        Trie root = new Trie();
        Trie curr = root;

        for (String ban : banned) {
            for (int i = 0; i < ban.length(); i++) {
                int idx = ban.charAt(i) - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new Trie();
                }
                curr = curr.next[idx];
            }
            curr.isBanned = true;
            curr = root;//reset current to root again
        }

        //add on to that trie
        int maxCount = 0;
        String res = "";
        paragraph = paragraph.toLowerCase();
        char[] pArray = paragraph.toCharArray();
        // insert words in paragraph into Trie
        for (int start = 0, end = 0; start < pArray.length; start = end + 1/**since end will always be a bad character**/) {
            // skip non-letter characters
            while (start < pArray.length && (pArray[start] < 'a' || pArray[start] > 'z')) {
                start++;
            }

            // insert consecutive letters(words) into Trie
            for (end = start; end < pArray.length && (pArray[end] >= 'a' && pArray[end] <= 'z'); end++) {
                int idx = pArray[end] - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new Trie();
                }
                curr = curr.next[idx];
            }
            // update statistics
            if (curr != root && !curr.isBanned) {
                curr.count++;
                if (curr.count > maxCount) {
                    maxCount = curr.count;
                    res = paragraph.substring(start, end);
                }
            }
            //set current to root again
            curr = root;
        }


        return res;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println(new MostCommonWord().mostCommonWord_UsingTrie(paragraph, banned));
        System.out.println(new MostCommonWord().mostCommonWord_approach_1(paragraph, banned));
    }
}
