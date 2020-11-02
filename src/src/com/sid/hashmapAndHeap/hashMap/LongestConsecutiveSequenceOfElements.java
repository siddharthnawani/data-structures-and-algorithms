package src.com.sid.hashmapAndHeap.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 * https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/lcqs-official/ojquestion#
 *
 * Question
 * 1. You are given a number n, representing the size of array a.
 * 2. You are given n numbers, representing elements of array a.
 * 3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).
 *
 * Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
 *
 * Sample Input
 * 17
 * 12
 * 5
 * 1
 * 2
 * 10
 * 2
 * 13
 * 7
 * 11
 * 8
 * 9
 * 11
 * 8
 * 9
 * 5
 * 6
 * 11
 * Sample Output
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 * 11
 * 12
 * 13
 *
 * */
public class LongestConsecutiveSequenceOfElements {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Map<Integer, Boolean> map = new HashMap<>();

        for (int val : arr) {
            map.put(val, true);
        }

        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int ml = 0;
        int msp = 0;
        for (int val : arr) {
            int tl = 1;
            if (map.get(val)) {
                while (map.containsKey(val + tl)) {
                    tl++;
                }
                if (tl > ml) {
                    ml = tl;
                    msp = val;
                }
            }
        }


        for (int i = 0; i < ml; i++) {
            System.out.println(msp + i);
        }


    }
}
