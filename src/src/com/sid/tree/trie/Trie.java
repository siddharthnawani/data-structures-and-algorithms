package src.com.sid.tree.trie;

/***
 *
 * 208. Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * */
class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean isEnd=false;
}
public class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(node.children[ch-'a']==null)
                node.children[ch-'a']=new TrieNode();
            node=node.children[ch-'a'];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(node.children[c-'a']==null)
                return false;
            node=node.children[c-'a'];
        }
        return node.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(node.children[c-'a']==null)
                return false;
            node=node.children[c-'a'];
        }
        return true;

    }

    public static void main(String[] args) {
        String word="apple";
        String prefix="app";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(obj.startsWith("sid"));
    }
}


