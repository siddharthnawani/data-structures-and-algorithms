package src.com.sid.misc;

/***
 *
 *520. Detect Capital
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 *
 *
 * **/

public class DetectCapital {
    public boolean detectCapitalUse(String word) {

        int cap=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch >=65 && ch <=91)
                cap++;
        }
        if(cap==word.length()) return true;
        if(cap==0) return true;
        char ch=word.charAt(0);
        if(cap==1 && (ch>=65 && ch<=91)) return true;
        return false;

    }

    public static void main(String[] args) {
        String s="USA";
        System.out.println(new DetectCapital().detectCapitalUse(s));
    }
}
