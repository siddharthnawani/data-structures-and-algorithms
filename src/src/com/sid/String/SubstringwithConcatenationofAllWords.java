package src.com.sid.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * https://www.youtube.com/watch?v=Mv5UNKdKwz4
 *
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * **/
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {

        //Step 1 make a map to store all the word and their count-- map1

        //Step 2 start traversing s into length of words

        //Step 3 then cut the sibstring into length of equal words and store these in another map.. lets say map2

        //Step 4 we just check if map1 and map2 is same, if yes then hurray.. store the index


        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        //Step 1
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map1.put(words[i], map1.getOrDefault(words[i], 0) + 1);
        }


        int l = 0;
        int tl = words.length * words[0].length();//total length of words array, so that we know the cuts length which we will make on s

        //Step 2
        while (l <= s.length() - tl) {


            String cut1 = s.substring(l, l + tl);
            //Step 3
            int word = 0, sub_word = 0;
            HashMap<String, Integer> map2 = new HashMap<>();

            while (word < words.length) {
                //Since all are of same length i added words[0].length
                String cut2 = cut1.substring(sub_word, sub_word + words[0].length());
                map2.put(cut2, map2.getOrDefault(cut2, 0) + 1);
                sub_word += words[0].length();
                word++;
            }
            if (map1.equals(map2)) {
                res.add(l);
            }
            l++;

        }

        return res;

    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        System.out.println(new SubstringwithConcatenationofAllWords().findSubstring(s, words));
    }
}
