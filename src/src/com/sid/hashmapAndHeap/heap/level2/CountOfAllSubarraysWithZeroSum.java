package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-all-subarrays-with-zero-sum-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array(arr) of integers.
 * 2. You have to find the count of all subarrays with sum 0.
 * <p>
 * Sample Input
 * 8
 * 15 -2 2 -8 1 7 10 23
 * Sample Output
 * 3
 **/
public class CountOfAllSubarraysWithZeroSum {
    public static int solution(int[] arr) {
        int count = 0;
        int sum = 0;
        int i = 0;
        //map of sum and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);

        while (i < arr.length) {

            sum += arr[i];
            if (map.containsKey(sum)) {
                int pfreq = map.get(sum);
                count += pfreq;
                map.put(sum, pfreq + 1);
            } else {
                map.put(sum, 1);
            }

            i++;
        }


        return count;
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
