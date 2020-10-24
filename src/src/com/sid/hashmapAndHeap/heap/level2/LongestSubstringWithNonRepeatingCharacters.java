package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-substring-with-unique-characters-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string.
 * 2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.
 * <p>
 * Sample Input
 * aabcbcdbca
 * Sample Output
 * 4
 **/
public class LongestSubstringWithNonRepeatingCharacters {
    public static int solution(String str) {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                } else {
                    //capture the correct result
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                }

            }

            //release
            while (j < i) {
                f1 = true;
                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    break;
                }

            }

            if (f1 == false && f2 == false) {
                break;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
