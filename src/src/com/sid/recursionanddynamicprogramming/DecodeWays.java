package src.com.sid.recursionanddynamicprogramming;

/***
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * */

public class DecodeWays {

    public int numDecodings(String s) {

        // return numDecodings(s,0);
        int[] arr=new int[s.length()+1];
        return numDecodings(s,0,arr);

    }
    private int numDecodings(String s,int index,int[] arr) {
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(index==s.length()-1) return 1;
        if(arr[index]>0) return arr[index];
        int way1=numDecodings(s,index+1);
        int way2=0;

        if(Integer.parseInt(s.substring(index,index+2)) <=26)
            way2=numDecodings(s,index+2);
        arr[index]=way1+way2;
        return way1+way2;

    }
    private int numDecodings(String s,int index) {
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(index==s.length()-1) return 1;

        int way1=numDecodings(s,index+1);
        int way2=0;

        if(Integer.parseInt(s.substring(index,index+2)) <=26)
            way2=numDecodings(s,index+2);
        return way1+way2;

    }
}
