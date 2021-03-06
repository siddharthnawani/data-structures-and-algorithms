package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-zeroes-and-ones-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array that contains only 0s and 1s.
 * 2. You have to find length of the longest subarray with equal number of 0s and 1s.
 * <p>
 * Sample Input
 * 6
 * 0 1 1 0 1 1
 * Sample Output
 * 4
 **/
public class LongestSubarrayWithEqualNumberOfZeroesAndOnes {

    public static int solution(int[] arr) {
        int ans = 0;

        //HashMap of sum and their 1st index of occurrence
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                int pidx = map.get(sum);
                int len = i - pidx;
                if (len > ans) {
                    ans = len;
                }

            } else {
                map.put(sum, i);
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
