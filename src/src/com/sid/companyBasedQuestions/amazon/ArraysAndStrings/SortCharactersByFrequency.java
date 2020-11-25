package src.com.sid.companyBasedQuestions.amazon.ArraysAndStrings;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 451. Sort Characters By Frequency
 * <p>
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * <p>
 * Further Reading
 * <p>
 * https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogm)-PriorityQueue-Solution-easy-to-understand
 **/
public class SortCharactersByFrequency {
    public String frequencySort_UsingBucketSort(String s) {

        //doing by bucket sort

        //create a hash map of char - freq

        //then create a bucket where index will point to freq and sort it acc to it

        //O(n)
        if (s == null || s.isEmpty()) return s;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<List<Character>> bucket = new ArrayList<>();

        int maxFreq = Collections.max(map.values());
        for (int i = 0; i <= maxFreq; i++) {
            bucket.add(new ArrayList<>());
        }
        for (Character ch : map.keySet()) {
            int count = map.get(ch);
            bucket.get(count).add(ch);
        }
        StringBuilder res = new StringBuilder();
        for (int i = bucket.size() - 1; i >= 1; i--) {
            for (Character ch : bucket.get(i)) {
                for (int j = 0; j < i; j++) {
                    res.append(ch);
                }
            }
        }

        return res.toString();


    }

    public String frequencySort_UsingBucketSort_faster(String s) {

        //doing by bucket sort

        //create a hash map of char - freq

        //then create a bucket where index will point to freq and sort it acc to it

        //O(n)
        if (s == null || s.isEmpty()) return s;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];


        for (Character ch : map.keySet()) {
            int count = map.get(ch);
            if (bucket[count] == null)
                bucket[count] = new ArrayList<>();

            bucket[count].add(ch);
        }
        StringBuilder res = new StringBuilder();
        for (int i = bucket.length - 1; i >= 1; i--) {
            if (bucket[i] != null) {
                for (Character ch : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        res.append(ch);
                    }
                }
            }

        }

        return res.toString();


    }

    public String frequencySort(String s) {

        //Max Priority Queue with a Pair/Entry Object
        if (s == null || s.isEmpty()) return s;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        StringBuilder res = new StringBuilder();
        while (pq.size() > 0) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++) {
                res.append(e.getKey());
            }
        }


        return res.toString();


    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(new SortCharactersByFrequency().frequencySort_UsingBucketSort(s));
        System.out.println(new SortCharactersByFrequency().frequencySort_UsingBucketSort_faster(s));
        System.out.println(new SortCharactersByFrequency().frequencySort(s));

    }
}
