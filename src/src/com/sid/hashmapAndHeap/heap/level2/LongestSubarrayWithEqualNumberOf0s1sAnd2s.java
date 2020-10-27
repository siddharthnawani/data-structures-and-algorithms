package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-0s-1s-and-2s-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array that contains only 0s, 1s, and 2s.
 * 2. You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.
 * <p>
 * Sample Input
 * 7
 * 0 1 0 2 0 1 0
 * Sample Output
 * 3
 **/
public class LongestSubarrayWithEqualNumberOf0s1sAnd2s {

    public static int solution(int[] arr) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        int dc10 = c1 - c0;
        int dc21 = c2 - c1;
        String key = dc21 + "#" + dc10;
        //Map of delta of thier cuount and the first occurrence
        map.put(key, -1);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                c0++;
            } else if (arr[i] == 1) {
                c1++;
            }
            if (arr[i] == 2) {
                c2++;
            }

            dc10 = c1 - c0;
            dc21 = c2 - c1;
            key = dc21 + "#" + dc10;

            if (map.containsKey(key)) {
                int pidx = map.get(key);
                int len = i - pidx;
                if (len > ans) {
                    ans = len;
                }
            } else {
                map.put(key, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
