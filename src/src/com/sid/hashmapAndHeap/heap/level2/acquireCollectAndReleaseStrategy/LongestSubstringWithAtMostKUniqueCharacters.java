package src.com.sid.hashmapAndHeap.heap.level2.acquireCollectAndReleaseStrategy;

import java.util.HashMap;
import java.util.Scanner;

/***
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-substring-with-at-most-k-unique-characters-official/ojquestion#
 *
 * Question
 * 1. You are given a string(str) and a number K.
 * 2. You have to find the length of longest substring of the given string that contains at most K unique characters.
 *
 * Sample Input
 * aabcbcdbca
 * 2
 * Sample Output
 * 4
 *
 * */
public class LongestSubstringWithAtMostKUniqueCharacters {
    public static int solution(String str, int k) {
        int ans = 0;
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire and collect
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() <= k) {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                } else {
                    break;
                }
            }

            //release and collect
            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                if (map.size() > k) {
                    continue;
                } else {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
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
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }
}
