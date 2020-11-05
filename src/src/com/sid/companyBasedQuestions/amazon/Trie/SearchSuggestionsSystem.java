package src.com.sid.companyBasedQuestions.amazon.Trie;

import java.util.*;

/***
 * Amazon | OA 2020 | Keyword Suggestions
 * Link : https://leetcode.com/discuss/interview-question/912886/amazon-oa-2020-keyword-suggestions
 *
 * Leetcode : 1268. Search Suggestions System
 *
 * https://leetcode.com/problems/search-suggestions-system/
 *
 * Question :
 *
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 *
 *
 *
 * **/
public class SearchSuggestionsSystem {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        LinkedList<String> suggestions = new LinkedList<>();
        boolean isEnd = false;
    }

    private void insert(String p, TrieNode root) {
        TrieNode node = root;
        for (char ch : p.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
            //add the word in the suggestions
            node.suggestions.add(p);
            Collections.sort(node.suggestions);

            if (node.suggestions.size() > 3) {
                node.suggestions.pollLast();
            }
        }
    }

    private List<List<String>> search(String searchWord, TrieNode root) {
        List<List<String>> ans = new ArrayList<>();
        TrieNode node = root;
        for (char ch : searchWord.toCharArray()) {
            if (node != null && node.children[ch - 'a'] != null) {
                node = node.children[ch - 'a'];
                ans.add(node.suggestions);
            }
        }
        return ans;

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String s : products) {
            insert(s, root);
        }
        return search(searchWord, root);
    }
    public List<List<String>> suggestedProductsSolutionUsingPQ(String[] products, String searchWord) {
        //created a max heap
        PriorityQueue<String> pq=new PriorityQueue<>(Comparator.reverseOrder());
        List<List<String>> ans= new ArrayList<>();

        for(int i=1;i<=searchWord.length();i++){
            String prefix=searchWord.substring(0,i);
            for(String s:products){
                if(s.startsWith(prefix)){
                    pq.offer(s);
                }
                if(pq.size()>3){
                    pq.poll();
                }
            }

            LinkedList<String> list=new LinkedList<>();
            while(pq.size()>0){
                list.addFirst(pq.poll());
            }

            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(new SearchSuggestionsSystem().suggestedProducts(products, searchWord));
        System.out.println(new SearchSuggestionsSystem().suggestedProductsSolutionUsingPQ(products, searchWord));

    }
}
