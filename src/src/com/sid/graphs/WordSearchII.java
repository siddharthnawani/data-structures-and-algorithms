package src.com.sid.graphs;

import src.com.sid.recursionanddynamicprogramming.WordBreakII;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Example:
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 **/
public class WordSearchII {
    class TrieNode {
        boolean isWord = false;
        TrieNode[] child = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    boolean flag[][];

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        int r = board.length;
        int c = board[0].length;
        flag = new boolean[r][c];

        addToTrie(words);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (root.child[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root, "", result);
                }
            }
        }

        return new LinkedList<>(result);

    }

    private void addToTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, String word, Set<String> result) {
        if (i == -1 || j == -1 || i == board.length || j == board[0].length || flag[i][j]
                || node.child[board[i][j] - 'a'] == null)
            return;
        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        word += board[i][j];
        if (node.isWord)
            result.add(word);
        dfs(board, i + 1, j, node, word, result);
        dfs(board, i - 1, j, node, word, result);
        dfs(board, i, j + 1, node, word, result);
        dfs(board, i, j - 1, node, word, result);
        flag[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new WordSearchII().findWords(board, words));

    }
}
