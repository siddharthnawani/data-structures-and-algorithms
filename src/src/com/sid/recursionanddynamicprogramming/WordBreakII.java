package src.com.sid.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 *
 * 140. Word Break II

 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 *
 * **/

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer,List<String>> hm=new HashMap<>();
        return wordBreakerHelper(s,0,wordDict,hm);

    }

    public List<String> wordBreakerHelper(String s, int start, List<String> wordDict, HashMap<Integer,List<String>> hm){

        if(hm.containsKey(start))
            return hm.get(start);

        List<String> validSubstr=new ArrayList<>();

        if(start==s.length()){
            validSubstr.add("");
        }
        for(int end=start+1;end<=s.length();end++){
            String prefix=s.substring(start,end);
            if(wordDict.contains(prefix)){
                List<String> suffixes=wordBreakerHelper(s,end,wordDict,hm);
                System.out.println("prefix "+prefix +" suffixes "+suffixes);
                for(String suffix: suffixes){
                    validSubstr.add(prefix+ (suffix.equals("") ? "":" ")+suffix);
                    System.out.println(" validSubstr "+validSubstr);
                }
            }
        }
        hm.put(start,validSubstr);

        return validSubstr;

    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        System.out.println(new WordBreakII().wordBreak(s, Arrays.asList(wordDict)));
    }
}
