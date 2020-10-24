package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-substring-with-exactly-k-unique-characters-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string(str) and a number K.
 * 2. You have to find length of the longest substring that has exactly k unique characters.
 * 3. If no such substring exists, print "-1".
 * <p>
 * Sample Input
 * aabcbcdbca
 * 2
 * Sample Output
 * 4
 **/
public class LongestSubstringWithExactlyKUniqueCharacters {
    public static int solution(String str, int k) {
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

                if (map.size() < k) {
                    continue;
                } else if (map.size() == k) {
                    //no need to break; keep collecting the answer
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                } else {
                    //break only if length increases the threshold
                    break;
                }
            }

            //release
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
                    //keep removing
                    continue;
                } else if (map.size() == k) {
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
