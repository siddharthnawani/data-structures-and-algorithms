package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/smallest-substring-of-a-string-containing-all-unique-characters-of-itself-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string str.
 * 2. You have to find the smallest window length that contains all the unique characters of the given string.
 * <p>
 * Sample Input
 * aabcbcdbca
 * Sample Output
 * 4
 **/
public class SmallestSubstringOfAStringContainingAllUniqueCharactersOfItself {

    public static int solution(String str) {
        int len = str.length(); //iniyialize with max value
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire till it is invalid ie map.size() < set.size()
            //the idea behind comparing size is keys are unique in hashmap so if the size os equal it means all the unique charaters are acquired
            while (i < str.length() - 1 && map.size() < set.size()) // minus 1 in str length since we are starting i from -1
            {
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }

            //collect and release
            while (j < i && map.size() == set.size()) {
                int plen = i - j;
                if (plen < len) {
                    len = plen;
                }
                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                f2 = true;
            }
            if (f1 == false && f2 == false) {
                break;
            }

        }


        return len;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
