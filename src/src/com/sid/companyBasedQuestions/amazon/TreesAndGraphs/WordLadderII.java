package src.com.sid.companyBasedQuestions.amazon.TreesAndGraphs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 126. Word Ladder II
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * Ref : https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
 * https://www.youtube.com/watch?v=mIZJIuMpI2M
 */
public class WordLadderII {

    //the idea is to firdst use bfs to store the shortest path in form of map
    //then use directed dfs to traverse the path
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> nodeNieghbours = new HashMap<>();//this is sort of adjacency list representation of graph that we will use to traverse.
        Map<String, Integer> distance = new HashMap<>();//this is used to map each node with distance frm root, so that our dfs can be directed
        Set<String> dict = new HashSet<>(wordList);//this is done since we dont want to manipulate the original list
        dict.add(beginWord);

        bfs(beginWord, endWord, nodeNieghbours, distance, dict);
        List<String> path = new ArrayList<>();//this will be used in dfs
        dfs(beginWord, endWord, nodeNieghbours, distance, dict, path, res);
        return res;

    }

    //// BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String beginWord, String endWord, Map<String, List<String>> nodeNieghbours, Map<String, Integer> distance, Set<String> dict) {
        for (String s : dict)
            nodeNieghbours.put(s, new ArrayList<>());
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        distance.put(beginWord, 0);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                int currDist = distance.get(word);
                List<String> neightbours = getNeighbours(word, dict);

                for (String neighbor : neightbours) {
                    nodeNieghbours.get(word).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currDist + 1);
                        if (neighbor.equals(endWord))
                            foundEnd = true;
                        else
                            q.add(neighbor);
                    }
                }

            }

            if (foundEnd)
                break;
        }
    }

    private List<String> getNeighbours(String word, Set<String> dict) {

        List<String> neighbours = new ArrayList<>();
        char[] chrs = word.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            char old = chrs[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == chrs[i])
                    continue;
                chrs[i] = ch;
                if (dict.contains(String.valueOf(chrs)))
                    neighbours.add(String.valueOf(chrs));
                chrs[i] = old;
            }
        }
        return neighbours;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String currWord, String endWord, Map<String, List<String>> nodeNieghbours, Map<String, Integer> distance, Set<String> dict, List<String> path, List<List<String>> res) {
        path.add(currWord);
        if (currWord.equals(endWord))
            res.add(new ArrayList<>(path));

        for (String neighbour : nodeNieghbours.get(currWord)) {
            if (distance.get(neighbour) == distance.get(currWord) + 1)
                dfs(neighbour, endWord, nodeNieghbours, distance, dict, path, res);
        }

        path.remove(path.size() - 1);
    }

}
