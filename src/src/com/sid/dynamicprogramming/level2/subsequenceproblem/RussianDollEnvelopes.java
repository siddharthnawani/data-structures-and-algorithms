package src.com.sid.dynamicprogramming.level2.subsequenceproblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/russian-doll-envelopes-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a number n, representing the number of envelopes.
 * 2. You are given n pair of numbers, representing the width and height of each envelope.
 * 3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
 * Note -> Rotation is not allowed.
 * <p>
 * Sample Input
 * 11
 * 17 5
 * 26 18
 * 25 34
 * 48 84
 * 63 72
 * 42 86
 * 9 55
 * 4 70
 * 21 45
 * 68 76
 * 58 51
 * Sample Output
 * 5
 **/
public class RussianDollEnvelopes {
    public static class Envelope implements Comparable<Envelope> {
        int w;
        int h;

        public int compareTo(Envelope o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Envelope[] envlps = new Envelope[n];
        for (int i = 0; i < envlps.length; i++) {
            String str = in.nextLine();
            envlps[i] = new Envelope();
            envlps[i].w = Integer.parseInt(str.split(" ")[0]);
            envlps[i].h = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(envlps);
        int[] lis = new int[envlps.length];
        for (int i = 0; i < envlps.length; i++) {
            Integer max = null;

            for (int j = 0; j < i; j++) {
                if (envlps[j].h < envlps[i].h && envlps[j].w < envlps[i].w) {
                    if (max == null || lis[j] > max) {
                        max = lis[j];
                    }
                }
            }

            if (max != null) {
                lis[i] = max + 1;
            } else {
                lis[i] = 1;
            }
        }

        int omax = 0;
        for (int i = 0; i < envlps.length; i++) {
            if (lis[i] > omax) {
                omax = lis[i];
            }
        }
        System.out.println(omax);
    }
}
