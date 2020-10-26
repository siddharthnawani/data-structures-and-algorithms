package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/largest-subarray-with-contiguous-elements-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array(arr) of integers. Values may be duplicated.
 * 2. You have to find the length of the largest subarray with contiguous elements.
 * <p>
 * Note -> The contiguous elements can be in any order(not necessarily in increasing order).
 * <p>
 * Sample Input
 * 3
 * 10 12 11
 * Sample Output
 * 3
 **/
public class LargestSubarrayWithContiguousElements {


    public static int solution(int[] arr) {
        int ans = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
            int min = arr[i];
            int max = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);

                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if (max - min == j - i) {
                    int len = j - i + 1;
                    if (len > ans) {
                        ans = len;
                    }
                }

            }

        }


        return ans;
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
