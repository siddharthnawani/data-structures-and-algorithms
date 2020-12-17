package src.com.sid.companyBasedQuestions.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Ref: https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 **/
public class WordLadder {
    public int ladderLength_bfs(String beginWord, String endWord, List<String> wordList) {
        //do a bfs starting from beginword
        //while adding into the queue make sure to conside ever possible option

        if (!wordList.contains(endWord)) return 0;
        Map<String, Boolean> vMap = new HashMap<>(); //visited map to keep track of words
        for (String s : wordList)
            vMap.put(s, false);
        int length = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vMap.put(beginWord, true);
        length++;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord))
                    return length;
                wordMatch(word, vMap, q);
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

    //bi directional bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
