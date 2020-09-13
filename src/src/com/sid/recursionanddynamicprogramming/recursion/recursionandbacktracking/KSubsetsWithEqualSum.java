package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/k-subsets-with-equal-sum-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array of n distinct integers.
 * 2. You have to divide these n integers into k non-empty subsets such that sum of integers of every
 * subset is same.
 * 3. If it is not possible to divide, then print "-1".
 * <p>
 * Sample Input
 * 6
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 3
 * Sample Output
 * [1, 6] [2, 5] [3, 4]
 */
public class KSubsetsWithEqualSum {

    private void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int ssssf, ArrayList<ArrayList<Integer>> ans) {

        if (vidx == arr.length) {

            if (ssssf == k) {
                boolean flag = true;
                for (int i = 0; i < subsetSum.length - 1; i++) {
                    if (subsetSum[i] != subsetSum[i + 1]) {
                        flag = false;
                        break;
                    }
                }//for loop

                if (flag) {
                    for (ArrayList<Integer> a : ans) {
                        System.out.print(a + " ");
                    }
                    System.out.println();
                }

            }

            return;
        }

        //recursovely check all the subsets
        //2 options wither be part of existing subset or make a new set

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).size() > 0) {
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr, vidx + 1, n, k, subsetSum, ssssf, ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() - 1);
            } else {
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr, vidx + 1, n, k, subsetSum, ssssf + 1, ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() - 1);
                break;
            }

        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        // if k is equal to 1, then whole array is your answer
        if (k == 1) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        //if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
        if (k > n || sum % k != 0) {
            System.out.println("-1");
            return;
        }
        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        new KSubsetsWithEqualSum().solution(arr, 0, n, k, subsetSum, 0, ans);
    }
}
