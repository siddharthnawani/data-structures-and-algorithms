package src.com.sid.hashmapAndHeap.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/merge-k-sorted-lists-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a list of lists, where each list is sorted.
 * 2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.
 * <p>
 * Sample Input
 * 4
 * 5
 * 10 20 30 40 50
 * 7
 * 5 7 9 11 19 55 57
 * 3
 * 1 2 3
 * 2
 * 32 39
 * Sample Output
 * 1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57
 **/
public class MergeKSortedLists {

    static class Pair implements Comparable<Pair> {
        int li;
        int di;
        int val;

        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }

        while (pq.size() > 0) {
            Pair p = pq.remove();
            System.out.print(p.val + " ");
            p.di++;

            if (p.di < lists.get(p.li).size()) {
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
