package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking.permutationsandcombinations;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/all-palindromic-permutations-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string of length n.
 * 2. You have to print all the palindromic permutations of the given string.
 * 3. If no palindromic permutation exists for the given string, print "-1".
 * <p>
 * Sample Input
 * aaabb
 * Sample Output
 * ababa
 * baaab
 */
public class AllPalindromicPermutations {

    private void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {

        if (cs > ts) {

            String rev = "";

            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }

            if (oddc != null) {
                asf += oddc;
            }
            asf += rev;
            System.out.println(asf);
            return;

        }

        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                //check for all the unique characters
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        //write your code here
        Character oddc = null;
        int oddchar = 0;
        int newlen = 0;

        for (Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);

            //store odd charater
            if (freq % 2 == 1) {
                oddchar++;
                oddc = ch;
            }

            fmap.put(ch, freq / 2);
            newlen += freq / 2;
        }

        if (oddchar > 1) {
            System.out.println(-1);
            return;
        }

        new AllPalindromicPermutations().generatepw(1, newlen, fmap, oddc, "");

    }
}
