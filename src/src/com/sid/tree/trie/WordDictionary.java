package src.com.sid.tree.trie;
/****
 *
 * 211. Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 *
 * **/


public class WordDictionary {

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode();
            node=node.children[c-'a'];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node=root;
        return search(word,0,node);
    }
    public boolean search(String word,int i,TrieNode node) {
        if(node==null) return false;
        if(i==word.length()) return node.isEnd;
        char c=word.charAt(i);

        if(c=='.')//traverse all the children of the nodes
        {
            for(int k=0;k<26;k++)
                if(search(word,i+1,node.children[k])) return true;
        }
        else{ //search normally

            if(search(word,i+1,node.children[c-'a'])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String word="bad";
        WordDictionary obj = new WordDictionary();
        obj.addWord(word);
        boolean param_2 = obj.search(word);
        System.out.println(param_2);
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search(".ade"));
    }

}



