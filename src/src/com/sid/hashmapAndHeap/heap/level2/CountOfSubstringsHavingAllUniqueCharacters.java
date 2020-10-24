package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/***
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-all-unique-characters-official/ojquestion#
 *
 * Question
 * 1. You are given a string.
 * 2. You have to find the count of valid substrings of the given string.
 * 3. Valid substring is defined as a substring that has all unique characters.
 *
 * Sample Input
 * aabcbcdbca
 * Sample Output
 * 24
 *
 * **/
public class CountOfSubstringsHavingAllUniqueCharacters {

    public static int solution(String str) {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            //acquire
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                } else {
                    // i-j will include all the new substrings
                    ans += i - j;
                }
            }

            //release
            while (j < i) {
                f1 = true;
                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    //collect this new string answer as well
                    ans += i - j;
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }

        }


        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
