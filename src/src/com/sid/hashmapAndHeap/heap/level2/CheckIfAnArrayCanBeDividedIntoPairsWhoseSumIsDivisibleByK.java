package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/check-if-an-array-cab-be-divided-into-pairs-whose-sum-is-divisible-by-k-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array(arr) of integers and a number K.
 * 2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
 * <p>
 * Sample Input
 * 4
 * 9 7 5 3
 * 6
 * Sample Output
 * true
 ***/
public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {

    public static void solution(int[] arr, int k) {
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int val : arr) {
            int rem = val % k;
            int f = fmap.getOrDefault(rem, 0);
            fmap.put(rem, f + 1);
        }

        for (int val : arr) {
            int rem = val % k;

            if (rem == 0) {
                int f = fmap.get(rem);
                //It is an odd number
                if (f % 2 != 0) {
                    System.out.println(false);
                    return;
                }
            } else if (2 * rem == k) { // same as checking if rem = k/2
                int f = fmap.get(rem);
                //It is an odd number
                if (f % 2 != 0) {
                    System.out.println(false);
                    return;
                }
            } else {
                int f = fmap.get(rem);
                int remf = fmap.getOrDefault(k - rem, -1);
                if (f != remf) {
                    System.out.println(false);
                    return;
                }
            }


        }

        System.out.println(true);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solution(arr, k);
    }
}
