package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-anagram-mappings-official/ojquestion#
 * <p>
 * Question
 * 1. You are given two integer arrays(A and B), where B is an anagram of A.
 * 2. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * 3. For every element in A, you have to print the index of that element in B.
 * <p>
 * Note -> Both arrays(A and B) are of the same length.
 * <p>
 * Sample Input
 * 6
 * 1 2 3 4 5 2
 * 4 3 2 1 5 2
 * Sample Output
 * 3 2 1 0 4 5
 **/
public class FindAnagramMappings {
    static class Pair {
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static int[] anagramMappings(int[] arr1, int[] arr2) {

        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                Pair p = map.get(arr2[i]);
                p.list.add(i);
            } else {
                Pair p = new Pair();
                p.list.add(i);
                map.put(arr2[i], p);
            }
        }

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            Pair p = map.get(arr1[i]);
            res[i] = p.list.get(p.idx);
            p.idx++;
        }

        return res;


    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
        }
        int[] res = anagramMappings(a, b);
        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
    }
}
