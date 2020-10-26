package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-all-anagrams-in-a-string-official/ojquestion#
 * <p>
 * Question
 * 1. You are given two strings s1 and s2.
 * 2. You have to find the count of s2's anagrams that are present in s1.
 * 3. Also, you have to print the start indices of such anagrams in s1.
 * <p>
 * Note -> Both s1 ad s2 consist of lowercase English letters only.
 * <p>
 * Sample Input
 * cbaebabacd
 * abc
 * Sample Output
 * 2
 * 0 6
 **/
public class FindAllAnagramsInAString {

    private static boolean compare(HashMap<Character, Integer> pmap, HashMap<Character, Integer> smap) {

        for (char sch : smap.keySet()) {
            if (pmap.getOrDefault(sch, 0) != smap.get(sch)) {
                return false;
            }
        }
        return true;

    }

    public static void findAnagrams(String s, String p) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();

        //make frequency map for pattern
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }

        //make frequency map for string as well but for the same characters length as in oattern
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

        int i = p.length();
        int count = 0;
        String ans = "";
        while (i < s.length()) {
            if (compare(pmap, smap) == true) {
                count++;
                ans += (i - p.length()) + " ";
            }

            //acquire a new character from window
            char cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha, 0) + 1);

            //release character from starting
            char chr = s.charAt(i - p.length());
            if (smap.get(chr) == 1) {
                smap.remove(chr);
            } else {
                smap.put(chr, smap.get(chr) - 1);
            }
            i++;
        }

        if (compare(pmap, smap) == true) {
            count++;
            ans += (i - p.length()) + " ";
        }

        System.out.println(count);
        System.out.println(ans);


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String p = scn.next();
        findAnagrams(s, p);
    }
}
