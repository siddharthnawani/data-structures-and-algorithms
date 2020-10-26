package src.com.sid.hashmapAndHeap.heap.level2.acquireCollectAndReleaseStrategy;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-at-most-k-unique-characters-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string(str) and a number K.
 * 2. You have to find the count of substrings of the given string that contains at most K unique characters.
 * <p>
 * Sample Input
 * aabcbcdbca
 * 2
 * Sample Output
 * 23
 **/
public class CountOfSubstringsHavingAtMostKUniqueCharacters {
    public static int solution(String str, int k) {
        int ans = 0;
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {


            //acquire and collect
            while (i < str.length() - 1) {

                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() <= k) {
                    int len = i - j;

                    ans += len;

                } else {
                    break;
                }
            }

            if (i == str.length() - 1 && map.size() <= k) {
                break;
            }


            //release and collect
            while (j < i) {

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

                    ans += len;

                    break;
                }

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
