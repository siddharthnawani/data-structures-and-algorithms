package src.com.sid.graphs;

import java.util.*;

/***
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * **/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Map<String, Boolean> vMap = new HashMap<>();
        for (String word : wordList)
            vMap.put(word, false);
        int length = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vMap.put(beginWord, true);
        length++;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.equals(endWord))
                    return length;
                wordMatch(w, vMap, q);
            }
            length++;
        }
        return 0;
    }

    private void wordMatch(String word, Map<String, Boolean> vMap, Queue<String> q) {
        for (int i = 0; i < word.length(); i++) {
            char[] w = word.toCharArray();
            for (int j = 0; j < 26; j++) {
                w[i] = (char) ('a' + j);
                String s = String.valueOf(w);
                if (vMap.containsKey(s) && vMap.get(s) == false) {
                    q.add(s);
                    vMap.put(s, true);
                }
            }
        }

    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }
}
