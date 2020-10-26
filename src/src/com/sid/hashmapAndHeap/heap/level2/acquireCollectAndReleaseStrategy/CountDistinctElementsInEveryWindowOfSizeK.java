package src.com.sid.hashmapAndHeap.heap.level2.acquireCollectAndReleaseStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-distinct-elements-in-every-window-of-size-k-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array(arr) of integers and a number K.
 * 2. You have to find the count of distinct numbers in all windows of size k.
 * <p>
 * Sample Input
 * 7
 * 1 2 1 3 4 2 3
 * 4
 * Sample Output
 * 3 4 4 3
 ***/
public class CountDistinctElementsInEveryWindowOfSizeK {
    public static ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //build a frequency map of first k-1 elements
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //acquire the k th elemente, work on it, and release the first element

        for (int i = 0, j = k - 1; j < arr.length; i++, j++) {

            //acquire
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            //work
            res.add(map.size());

            //release the ith elelment
            int freq = map.get(arr[i]);
            if (freq == 1) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], map.get(arr[i]) - 1);
            }


        }

        return res;
    }

    public static ArrayList<Integer> solution2(int[] arr, int k) {
        ArrayList < Integer > res = new ArrayList < > ();
        HashMap < Integer, Integer > map = new HashMap < > ();

        int j = 0;
        int i = 0;

        //build a frequency map of first k-1 elements
        while (j <= k - 2) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            j++;
        }

        //acquire the k th elemente, work on it, and release the first element

        while (j < arr.length) {

            //acquire
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            //work
            res.add(map.size());

            //release the ith elelment
            int freq = map.get(arr[i]);
            if (freq == 1) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], map.get(arr[i]) - 1);
            }

            i++;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> ans = solution(arr, k);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
