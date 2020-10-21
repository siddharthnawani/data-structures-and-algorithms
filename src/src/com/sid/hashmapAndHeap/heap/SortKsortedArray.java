package src.com.sid.hashmapAndHeap.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Question
 * 1. You are given a number n, representing the size of array a.
 * 2. You are given n numbers, representing elements of array a.
 * 3. The array is nearly sorted. Every element is at-max displaced k spots left or right to it's position in the sorted array. Hence it is being called k-sorted array.
 * 4. You are required to sort and print the sorted array.
 * <p>
 * Sample Input
 * 9
 * 3
 * 2
 * 4
 * 1
 * 6
 * 5
 * 7
 * 9
 * 8
 * 3
 * Sample Output
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 **/
public class SortKsortedArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }

    }
}
