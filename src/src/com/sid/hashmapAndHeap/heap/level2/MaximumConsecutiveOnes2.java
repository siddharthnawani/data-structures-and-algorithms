package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/maximum-consecutive-ones-ii-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array(arr) which contains only 0's and 1's and a number K.
 * 2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most K zeroes.
 * <p>
 * Sample Input
 * 6
 * 1 1 0 0 1 1
 * 1
 * Sample Output
 * 3
 **/
public class MaximumConsecutiveOnes2 {

    public static int solution(int[] arr, int k) {
        int ans = 0;
        int count = 0; // to maintain no of 0's
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }

            while (count > k) {
                j++;
                if (arr[j] == 0) {
                    count--;
                }

            }

            if (count <= k) {
                int len = i - j;
                if (len > ans) {
                    ans = len;
                }
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
