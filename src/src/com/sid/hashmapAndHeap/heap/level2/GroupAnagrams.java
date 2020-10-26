package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.*;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/group-anagrams-official/ojquestion#
 * <p>
 * Question
 * 1. You are given an array of strings.
 * 2. You have to group anagrams together.
 * <p>
 * Note -> Every string consists of lower-case English letters only.
 * <p>
 * Sample Input
 * 5
 * pepcoding codingpep pepper rapper repepp
 * Sample Output
 * codingpep pepcoding
 * pepper repepp
 * rapper
 **/
public class GroupAnagrams {

    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();

        for (String s : strs) {

            HashMap<Character, Integer> fmap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }

            if (bmap.containsKey(fmap)) {
                ArrayList<String> list = bmap.get(fmap);
                list.add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                bmap.put(fmap, list);
            }

        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (ArrayList<String> l : bmap.values()) {
            res.add(l);
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
        for (ArrayList<String> lst : anagramsGrouped) {
            Collections.sort(lst);
        }
        anagramsGrouped.sort(new ListComparator());
        display(anagramsGrouped);
    }

    // it is used to make the result unique
    static class ListComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> l1, List<String> l2) {
            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            String l1str = l1.get(0);
            String l2str = l2.get(0);
            return l1str.compareTo(l2str);

        }
    }

    public static void display(ArrayList<ArrayList<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> currList = list.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}
