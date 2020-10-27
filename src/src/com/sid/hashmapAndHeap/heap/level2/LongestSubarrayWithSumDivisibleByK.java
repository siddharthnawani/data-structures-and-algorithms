package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-sum-divisible-by-k-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array of integers(arr) and a number K.
 * 2. You have to find length of the longest subarray whose sum is divisible by K.
 * <p>
 * Sample Input
 * 6
 * 2 7 6 1 4 5
 * 3
 * Sample Output
 * 4
 **/
public class LongestSubarrayWithSumDivisibleByK {

    public static int solution(int[] arr, int k) {
        int ans = 0;

        //hashmap of remainder of sum after dividing by k and their index
        HashMap<Integer, Integer> map = new HashMap<>();
        int rem = 0;
        int sum = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            rem = sum % k;
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                int pidx = map.get(rem);
                int len = i - pidx;
                if (len > ans) {
                    ans = len;
                }
            } else {
                map.put(rem, i);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}
