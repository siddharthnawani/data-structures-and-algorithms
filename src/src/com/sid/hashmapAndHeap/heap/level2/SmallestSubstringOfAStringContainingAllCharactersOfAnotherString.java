package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/smallest-substring-of-a-string-containing-all-characters-of-another-string-official/ojquestion#
 * <p>
 * Question
 * 1. You are given two strings s1 and s2 containing lowercase english alphabets.
 * 2. You have to find the smallest substring of s1 that contains all the characters of s2.
 * 3. If no such substring exists, print blank string("").
 * <p>
 * Sample Input
 * timetopractice
 * toc
 * Sample Output
 * toprac
 **/
public class SmallestSubstringOfAStringContainingAllCharactersOfAnotherString {

    public static String solution(String s1, String s2) {
        String ans = "";

        //create frequency map of s2
        HashMap<Character, Integer> fmap2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            fmap2.put(ch, fmap2.getOrDefault(ch, 0) + 1);
        }

        // run a loop continuously acquire and then release answer to check the minium substring of s1
        int mact = 0; //matching count of s1 wrt s2
        int dmct = s2.length();
        HashMap<Character, Integer> fmap1 = new HashMap<>();
        int i = -1; //ending index of acquire
        int j = -1; //starting index of acquire


        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //fill the frequency of s1
            //acquire phase
            while (i < s1.length() - 1 && mact < dmct) {
                i++;
                char ch = s1.charAt(i);
                fmap1.put(ch, fmap1.getOrDefault(ch, 0) + 1);
                if (fmap1.getOrDefault(ch, 0) <= fmap2.getOrDefault(ch, 0)) {
                    mact++;
                }
                f1 = true;
            }

            //when we will come ou of aboove llop we would have acquired atleast minimum number of character
            //present in s2

            //collect answer and release characters
            while (j < i && mact == dmct) {
                String pans = s1.substring(j + 1, i + 1);
                if (ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }
                j++;
                char ch = s1.charAt(j);
                if (fmap1.get(ch) == 1) {
                    fmap1.remove(ch);
                } else {
                    fmap1.put(ch, fmap1.get(ch) - 1);
                }

                if (fmap1.getOrDefault(ch, 0) < fmap2.getOrDefault(ch, 0)) {
                    mact--;
                }
                f2 = true;
            }


            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }
}
