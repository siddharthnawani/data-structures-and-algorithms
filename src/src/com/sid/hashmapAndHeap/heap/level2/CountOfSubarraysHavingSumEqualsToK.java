package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-subarrays-having-sum-equals-to-k-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array of integers(arr) and a number K.
 * 2. You have to find the count of subarrays whose sum equals k.
 * <p>
 * Sample Input
 * 3
 * 1 1 1
 * 2
 * Sample Output
 * 2
 **/
public class CountOfSubarraysHavingSumEqualsToK {
    public static int solution(int[] arr, int target) {
        int ans = 0;
        int sum = 0;
        //sum - frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                ans += map.get(sum - target);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
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
        int target = scn.nextInt();
        System.out.println(solution(arr, target));
    }
}
