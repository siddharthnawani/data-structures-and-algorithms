package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/largest-subarray-with-zero-sum-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array(arr) of integers.
 * 2. You have to find the length of the largest subarray with sum 0.
 * <p>
 * Sample Input
 * 8
 * 15 -2 2 -8 1 7 10 23
 * Sample Output
 * 5
 **/
public class LargestSubarrayWithZeroSum {

    public static int solution(int[] arr) {
        //map of sum and their first occurence
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int sum = 0;
        int mlen = 0;

        // 0 sum at -1 index
        map.put(sum, -1);

        while (i < arr.length) {
            sum += arr[i];

            if (map.containsKey(sum) == false) {
                map.put(sum, i);
            } else {
                int prevIndex = map.get(sum);
                int len = i - prevIndex;

                if (len > mlen) {
                    mlen = len;
                }
            }
            i++;

        }

        return mlen;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
